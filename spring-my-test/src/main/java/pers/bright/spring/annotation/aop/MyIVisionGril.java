package pers.bright.spring.annotation.aop;

import org.springframework.stereotype.Component;

@Component
public class MyIVisionGril implements IVisionGril {

	@Override
	public void lookMore(Object gril) {
		// TODO Auto-generated method stub
		System.out.println("MyIVisionGril lookMore "+gril);
	}

}
