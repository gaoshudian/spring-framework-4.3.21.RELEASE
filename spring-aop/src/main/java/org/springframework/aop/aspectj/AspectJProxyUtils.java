/*
 * Copyright 2002-2012 the original author or authors.
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

package org.springframework.aop.aspectj;

import java.util.List;

import org.springframework.aop.Advisor;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.interceptor.ExposeInvocationInterceptor;

/**
 * Utility methods for working with AspectJ proxies.
 *
 * @author Rod Johnson
 * @author Ramnivas Laddad
 * @since 2.0
 */
public abstract class AspectJProxyUtils {

	/**
     * 如果发现有AspectJ的Advisor存在，并且advisors还不包含有ExposeInvocationInterceptor.ADVISOR，那就在第一个位置上调添加一个ExposeInvocationInterceptor.ADVISOR；
     * 这个`ExposeInvocationInterceptor.ADVISOR`的作用：公开当前的Spring AOP调用(对于某些AspectJ切入点匹配是必要的)，并使当前的AspectJ连接点可用
	 */
	public static boolean makeAdvisorChainAspectJCapableIfNecessary(List<Advisor> advisors) {
		if (!advisors.isEmpty()) {
			boolean foundAspectJAdvice = false;
			for (Advisor advisor : advisors) {
				if (isAspectJAdvice(advisor)) {
					foundAspectJAdvice = true;
				}
			}
			if (foundAspectJAdvice && !advisors.contains(ExposeInvocationInterceptor.ADVISOR)) {
				advisors.add(0, ExposeInvocationInterceptor.ADVISOR);
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断该Advisor是否是AspectJ的的增强器
	 */
	private static boolean isAspectJAdvice(Advisor advisor) {
		return (advisor instanceof InstantiationModelAwarePointcutAdvisor ||
				advisor.getAdvice() instanceof AbstractAspectJAdvice ||
				(advisor instanceof PointcutAdvisor && ((PointcutAdvisor) advisor).getPointcut() instanceof AspectJExpressionPointcut));
	}

}
