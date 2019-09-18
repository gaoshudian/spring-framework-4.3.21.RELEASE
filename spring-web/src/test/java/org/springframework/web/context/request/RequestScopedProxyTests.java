/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.web.context.request;

import org.junit.Before;
import org.junit.Test;

import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mock.web.test.MockHttpServletRequest;
import org.springframework.tests.sample.beans.DerivedTestBean;
import org.springframework.tests.sample.beans.ITestBean;
import org.springframework.tests.sample.beans.TestBean;
import org.springframework.tests.sample.beans.factory.DummyFactory;

import static org.junit.Assert.*;

/**
 * 名称: RequestScopedProxyTests.java
 * 描述: 测试<aop:scoped-proxy/>的作用
 *
 * 作用:通知Spring容器去代理这个bean -->
 *  scope为request的bean，在每个请求到来时，会创建一个实际对象与当前的请求 对应。
 *  而使用bean的代理对象时，会通过某种方式获得当前的请求，再根据当前这个请求，获得对应bean的实际对象。
 *  使用代理对象间接操控的就是与当前请求对应的bean的实际对象.
 *
 *
 * @author gaoshudian
 * @date   2019/9/18 3:34 PM
*/
public class RequestScopedProxyTests {

	private final DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();


	@Before
	public void setup() {
		this.beanFactory.registerScope("request", new RequestScope());
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(this.beanFactory);
		reader.loadBeanDefinitions(new ClassPathResource("requestScopedProxyTests.xml", getClass()));
		this.beanFactory.preInstantiateSingletons();
	}


	@Test
	public void testGetFromScope() throws Exception {
		String name = "requestScopedObject";
		TestBean bean = (TestBean) this.beanFactory.getBean(name);
		assertTrue(AopUtils.isCglibProxy(bean));

		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestAttributes requestAttributes = new ServletRequestAttributes(request);
		RequestContextHolder.setRequestAttributes(requestAttributes);

		try {
//			assertNull(request.getAttribute("scopedTarget." + name));
			assertEquals("scoped", bean.getName());
			assertNotNull(request.getAttribute("scopedTarget." + name));
			TestBean target = (TestBean) request.getAttribute("scopedTarget." + name);
			assertEquals(TestBean.class, target.getClass());
			assertEquals("scoped", target.getName());
			assertSame(bean, this.beanFactory.getBean(name));
			assertEquals(bean.toString(), target.toString());
		}
		finally {
			RequestContextHolder.setRequestAttributes(null);
		}
	}

	@Test
	public void testGetFromScopeThroughDynamicProxy() throws Exception {
		String name = "requestScopedProxy";
		ITestBean bean = (ITestBean) this.beanFactory.getBean(name);
		assertTrue(AopUtils.isJdkDynamicProxy(bean));

		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestAttributes requestAttributes = new ServletRequestAttributes(request);
		RequestContextHolder.setRequestAttributes(requestAttributes);

		try {
			assertNull(request.getAttribute("scopedTarget." + name));
			assertEquals("scoped", bean.getName());
			assertNotNull(request.getAttribute("scopedTarget." + name));
			TestBean target = (TestBean) request.getAttribute("scopedTarget." + name);
			assertEquals(TestBean.class, target.getClass());
			assertEquals("scoped", target.getName());
			assertSame(bean, this.beanFactory.getBean(name));
			assertEquals(bean.toString(), target.toString());
		}
		finally {
			RequestContextHolder.setRequestAttributes(null);
		}
	}

	@Test
	public void testDestructionAtRequestCompletion() throws Exception {
		String name = "requestScopedDisposableObject";
		DerivedTestBean bean = (DerivedTestBean) this.beanFactory.getBean(name);
		assertTrue(AopUtils.isCglibProxy(bean));

		MockHttpServletRequest request = new MockHttpServletRequest();
		ServletRequestAttributes requestAttributes = new ServletRequestAttributes(request);
		RequestContextHolder.setRequestAttributes(requestAttributes);

		try {
			assertNull(request.getAttribute("scopedTarget." + name));
			assertEquals("scoped", bean.getName());
			assertNotNull(request.getAttribute("scopedTarget." + name));
			assertEquals(DerivedTestBean.class, request.getAttribute("scopedTarget." + name).getClass());
			assertEquals("scoped", ((TestBean) request.getAttribute("scopedTarget." + name)).getName());
			assertSame(bean, this.beanFactory.getBean(name));

			requestAttributes.requestCompleted();
			assertTrue(((TestBean) request.getAttribute("scopedTarget." + name)).wasDestroyed());
		}
		finally {
			RequestContextHolder.setRequestAttributes(null);
		}
	}

	@Test
	public void testGetFromFactoryBeanInScope() throws Exception {
		String name = "requestScopedFactoryBean";
		TestBean bean = (TestBean) this.beanFactory.getBean(name);
		assertTrue(AopUtils.isCglibProxy(bean));

		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestAttributes requestAttributes = new ServletRequestAttributes(request);
		RequestContextHolder.setRequestAttributes(requestAttributes);

		try {
			assertNull(request.getAttribute("scopedTarget." + name));
			assertEquals(DummyFactory.SINGLETON_NAME, bean.getName());
			assertNotNull(request.getAttribute("scopedTarget." + name));
			assertEquals(DummyFactory.class, request.getAttribute("scopedTarget." + name).getClass());
			assertSame(bean, this.beanFactory.getBean(name));
		}
		finally {
			RequestContextHolder.setRequestAttributes(null);
		}
	}

	@Test
	public void testGetInnerBeanFromScope() throws Exception {
		TestBean bean = (TestBean) this.beanFactory.getBean("outerBean");
		assertFalse(AopUtils.isAopProxy(bean));
		assertTrue(AopUtils.isCglibProxy(bean.getSpouse()));

		String name = "scopedInnerBean";

		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestAttributes requestAttributes = new ServletRequestAttributes(request);
		RequestContextHolder.setRequestAttributes(requestAttributes);

		try {
			assertNull(request.getAttribute("scopedTarget." + name));
			assertEquals("scoped", bean.getSpouse().getName());
			assertNotNull(request.getAttribute("scopedTarget." + name));
			assertEquals(TestBean.class, request.getAttribute("scopedTarget." + name).getClass());
			assertEquals("scoped", ((TestBean) request.getAttribute("scopedTarget." + name)).getName());
		}
		finally {
			RequestContextHolder.setRequestAttributes(null);
		}
	}

	@Test
	public void testGetAnonymousInnerBeanFromScope() throws Exception {
		TestBean bean = (TestBean) this.beanFactory.getBean("outerBean");
		assertFalse(AopUtils.isAopProxy(bean));
		assertTrue(AopUtils.isCglibProxy(bean.getSpouse()));

		BeanDefinition beanDef = this.beanFactory.getBeanDefinition("outerBean");
		BeanDefinitionHolder innerBeanDef =
				(BeanDefinitionHolder) beanDef.getPropertyValues().getPropertyValue("spouse").getValue();
		String name = innerBeanDef.getBeanName();

		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestAttributes requestAttributes = new ServletRequestAttributes(request);
		RequestContextHolder.setRequestAttributes(requestAttributes);

		try {
			assertNull(request.getAttribute("scopedTarget." + name));
			assertEquals("scoped", bean.getSpouse().getName());
			assertNotNull(request.getAttribute("scopedTarget." + name));
			assertEquals(TestBean.class, request.getAttribute("scopedTarget." + name).getClass());
			assertEquals("scoped", ((TestBean) request.getAttribute("scopedTarget." + name)).getName());
		}
		finally {
			RequestContextHolder.setRequestAttributes(null);
		}
	}

}
