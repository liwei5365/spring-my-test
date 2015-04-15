package pers.bright.spring.annotation.aop.old;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

@Component("aop.test1.before")
public class BeforeMethodBeforeAdvice implements MethodBeforeAdvice {
	@Override
	public String toString() {
		return "BeforeMethodBeforeAdvice [method=" + method + ", args="
				+ Arrays.toString(args) + ", target=" + target + "]";
	}
	private Method method;
	private Object[] args;
	private Object target;
	@Override
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		// TODO Auto-generated method stub
		this.method=method;
		this.args=args;
		this.target=target;
		System.out.println(this.toString());
	}

}
