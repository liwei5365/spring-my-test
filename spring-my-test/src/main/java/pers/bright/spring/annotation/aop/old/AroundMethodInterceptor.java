package pers.bright.spring.annotation.aop.old;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Component("aop.test1.around")
public class AroundMethodInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("AroundMethodInterceptor start ......");
		Object or=invocation.proceed();
		System.out.println("AroundMethodInterceptor end ......");
		return or;
	}

}
