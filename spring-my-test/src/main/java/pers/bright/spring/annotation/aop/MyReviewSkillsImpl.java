package pers.bright.spring.annotation.aop;

import org.springframework.stereotype.Service;

@Service("aoptest.impl")
public class MyReviewSkillsImpl implements IReviewSkills {

	@Override
	public void recall(Object oper) {
		// TODO Auto-generated method stub
		System.out.println("MyReviewSkillsImpl recall "+String.valueOf(oper));
	}

	@Override
	public String reMemory(String young) {
		// TODO Auto-generated method stub
		System.out.println("MyReviewSkillsImpl reMemory "+young);
		return "re-"+young;
	}

	@Override
	public void dizzying() throws Exception {
		// TODO Auto-generated method stub
		throw new Exception("dizzying");
	}

}
