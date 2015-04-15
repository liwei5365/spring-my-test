package pers.bright.spring.annotation.aop.old;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.IntroductionInterceptor;
import org.springframework.stereotype.Component;

import pers.bright.spring.annotation.aop.IVisionGril;

@Component("aop.test1.myintroduction")
public class MyIntroductionInterceptor implements IntroductionInterceptor,IVisionGril {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		if(implementsInterface(invocation.getMethod().getDeclaringClass())){  
            return invocation.getMethod().invoke(this, invocation.getArguments());  
        }  
        else{  
            return invocation.proceed();  
        }  
	}

	@Override
	public boolean implementsInterface(Class<?> intf) {
		// TODO Auto-generated method stub
		return intf.equals(IVisionGril.class);
//		  boolean assignableFrom = intf.isAssignableFrom(IVisionGril.class);  
//	      return assignableFrom;  
	}

	@Override
	public void lookMore(Object gril) {
		// TODO Auto-generated method stub
		System.out.println("MyIntroductionInterceptor nice gril ...");
	}

}
