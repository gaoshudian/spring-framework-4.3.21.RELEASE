package my_demo.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;


/**
 * 要在Spring 中声明 AspectJ 切面, 只需要在 IOC 容器中将切面声明为 Bean 实例. 当
 * 在 Spring IOC 容器中初始化AspectJ 切面之后, Spring IOC容器就会为那些与AspectJ切面相匹配的Bean创建代理
 */
@Aspect
@Component
public class LoggingAspect {

	/**
	 * 定义一个方法, 用于声明切入点表达式. 一般地, 该方法中再不需要添入其他的代码.
	 * 使用 @Pointcut 来声明切入点表达式.
	 * 后面的其他通知直接使用方法名来引用当前的切入点表达式.
	 */
	@Pointcut("execution(public int my_demo.aop.annotation.ArithmeticCalculator.*(..))")
	public void declareJointPointExpression(){}

	//在 com.atguigu.spring.aop.ArithmeticCalculator 接口的每一个实现类的每一个方法开始之前执行一段代码
	@Before("declareJointPointExpression()")
	public void beforeMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		Object [] args = joinPoint.getArgs();

		System.out.println("前置通知:The method " + methodName + " begins with " + Arrays.asList(args));
	}

	//后置通知：在目标方法执行后(无论是否发生异常),执行的通知
	//在后置通知中还不能访问目标方法执行的结果
	@After("declareJointPointExpression()")
	public void afterMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("后置通知:The method " + methodName + " ends");
	}

	/*
	 在方法法正常结束后执行的代码返回通知是可以访问到方法的返回值的!

	 在返回通知中, 只要将 returning 属性添加到 @AfterReturning 注解中, 就可以访问连接点的返回值.
	 该属性的值即为用来传入返回值的参数名称
	 */
	@AfterReturning(value="declareJointPointExpression()", returning="result")
	public void afterReturning(JoinPoint joinPoint, Object result){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("返回通知：The method " + methodName + " ends with " + result);
	}

	/*
	 在目标方法出现异常时会执行的代码;可以访问到异常对象; 且可以指定在出现特定异常时在执行通知代码

	 将throwing属性添加到@AfterThrowing注解中,也可以访问连接点抛出的异常. Throwable 是所有错误和异常类的超类.
	 所以在异常通知方法可以捕获到任何错误和异常.

	 如果只对某种特殊的异常类型感兴趣, 可以将参数声明为其他异常的参数类型. 然后通知就只在抛出这个类型及其子类的异常时才被执行.
	 */
	@AfterThrowing(value="declareJointPointExpression()", throwing="e")
	public void afterThrowing(JoinPoint joinPoint, Exception e){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("异常通知...The method " + methodName + " occurs excetion:" + e);
	}

	/**
	 * 环绕通知需要携带 ProceedingJoinPoint 类型的参数.
	 * 环绕通知类似于动态代理的全过程: ProceedingJoinPoint 类型的参数可以决定是否执行目标方法.
	 * 且环绕通知必须有返回值, 返回值即为目标方法的返回值
	 */
	@Around("declareJointPointExpression()")
	public Object aroundMethod(ProceedingJoinPoint pjd){
		Object result;
		String methodName = pjd.getSignature().getName();
		try {
			//前置通知
			System.out.println("环绕通知-前置通知:The method " + methodName + " begins with " + Arrays.asList(pjd.getArgs()));
			//执行目标方法
			result = pjd.proceed();
			//返回通知
			System.out.println("环绕通知-返回通知:The method " + methodName + " ends with " + result);
		} catch (Throwable e) {
			//异常通知
			System.out.println("环绕通知-异常通知:The method " + methodName + " occurs exception:" + e);
			throw new RuntimeException(e);
		}
		//后置通知
		System.out.println("环绕通知-后置通知:The method " + methodName + " ends");
		return result;
	}

}
