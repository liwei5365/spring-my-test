package pers.bright.spring.annotation.aop.now;

import org.springframework.stereotype.Component;

@Component("messClass")
@MyAspectAn
public class MessAspectTest extends MessFather{

	public void recall(Object oper) {
		System.out.println("MessAspectTest recall");
	}
	@MyAspectAn
	public String reMemory(String young) {
		System.out.println("MessAspectTest reMemory");
		return "MessAspectTest";
	}

	public void dizzying() throws Exception {
		throw new Exception("MessAspectTest reMemory ");
	}
}
