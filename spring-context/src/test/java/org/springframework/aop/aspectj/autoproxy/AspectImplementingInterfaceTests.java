/*
 * Copyright 2002-2013 the original author or authors.
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

package org.springframework.aop.aspectj.autoproxy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.junit.Test;

import org.springframework.aop.framework.Advised;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.tests.sample.beans.ITestBean;

import static org.junit.Assert.*;

/**
 * 名称: AspectImplementingInterfaceTests.java
 * 描述: 测试AOP,纯xml配置方式，切面以<aop:aspect/>标签实现
 *
 * <aop:config>
 *     <aop:aspect ref="interfaceExtendingAspect">
 *         <aop:pointcut id="anyOperation" expression="execution(* *(..))"/>
 *         <aop:around pointcut-ref="anyOperation" method="increment"/>
 *     </aop:aspect>
 * </aop:config>
 *
 * <bean id="testBean" class="org.springframework.tests.sample.beans.TestBean"/>
 * <bean id="interfaceExtendingAspect"
 *       class="org.springframework.aop.aspectj.autoproxy.InterfaceExtendingAspect"/>
 *
 * @author gaoshudian
 * @date   2019/9/22 10:25 PM
*/
public final class AspectImplementingInterfaceTests {

	@Test
	public void testProxyCreation() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(getClass().getSimpleName() + "-context.xml", getClass());

		ITestBean testBean = (ITestBean) ctx.getBean("testBean");
		AnInterface interfaceExtendingAspect = (AnInterface) ctx.getBean("interfaceExtendingAspect");

		assertTrue(testBean instanceof Advised);
		assertFalse(interfaceExtendingAspect instanceof Advised);
	}

}


interface AnInterface {
	public void interfaceMethod();
}


class InterfaceExtendingAspect implements AnInterface {
	public void increment(ProceedingJoinPoint pjp) throws Throwable {
		pjp.proceed();
	}

	@Override
	public void interfaceMethod() {
	}
}
