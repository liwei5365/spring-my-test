package pers.bright.spring.annotation.aop.now;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import pers.bright.spring.annotation.aop.IReviewSkills;
import pers.bright.spring.annotation.aop.IReviewSkillsAdaptive;
import pers.bright.spring.annotation.aop.MyReviewSkillsImpl;

@Aspect
@Component
public class MyFirstAspect extends IReviewSkillsAdaptive{
	
	@Pointcut("execution(* pers.bright.spring.annotation.aop.MyReviewSkillsImpl.recall(..))")
	public void recallPointCut(){
		
	}
	@Pointcut("within(pers.bright.spring.annotation.aop.now.MessAspectTest)")
	public void exeMessObjectMethod(){
		
	}
	@Pointcut("within(pers.bright.spring.annotation.aop.now.*)")
	public void exeMessObjectMethodStar(){
		
	}
	@Pointcut("within(pers.bright.spring.annotation.aop.IReviewSkills)")
	public void exeMessObjectMethodInterface(){
		
	}
	@Pointcut("within(pers.bright.spring.annotation.aop.now.MessFather)")
	public void exeMessObjectMethodFather(){
		
	}
	@Pointcut("@within(pers.bright.spring.annotation.aop.now.MyAspectAn)")
	public void exeMessObjectAn(){
		
	}
	@Pointcut("target(pers.bright.spring.annotation.aop.MyReviewSkillsImpl)")
	public void exetarget(){
		
	}
	@Pointcut("target(pers.bright.spring.annotation.aop.now.MessFather)")
	public void exetarget2(){
		
	}
	@Pointcut("@target(pers.bright.spring.annotation.aop.now.MyAspectAn)")
	public void exeattarget(){
		
	}
	@Pointcut("args(java.lang.String)")
	public void exeargs(){
		
	}
	@Pointcut("@annotation(pers.bright.spring.annotation.aop.now.MyAspectAn)")
	public void exeannotation(){
		
	}
	@Pointcut("bean(aoptest.*)")
	public void exebean(){
		
	}
//	@Before("execution(* pers..IReviewSkills.recall(..))")
//	@Before("exeMessObjectMethod()")
//	@Before("exeMessObjectMethodInterface()")
//	@Before("exeMessObjectMethodFather()")
//	@Before("exeMessObjectMethodStar()")
//	@Before("exeMessObjectAn()")
//	@Before("exetarget()")
//	@Before("exetarget2()")
//	@Before("exeattarget()")
//	@Before("exeargs()")
//	@Before("exeannotation()")
//	@Before("exebean()")
	public void dataFight(){
		System.out.println("MyFirstAspect dataFight .....");
	}
//	@Before(value="exebean()&&target(target)",argNames="target")
//	@Before(value="target(target)",argNames="target")
	public void dataFightArgsImput(JoinPoint jp,MessAspectTest target){
		System.out.println("dataFightArgsImput jp = "+String.valueOf(jp));
		System.out.println("dataFightArgsImput target = "+String.valueOf(target));
	}
//	@Before(value="target(target)&&args(str)")
	public void dataFightArgsImput2(JoinPoint jp,MyReviewSkillsImpl target,
									String str){
		System.out.println("dataFightArgsImput jp = "+String.valueOf(jp));
		System.out.println("dataFightArgsImput target = "+String.valueOf(target));
		System.out.println("dataFightArgsImput str = "+String.valueOf(str));
	}
//	@Before(value="target(target)&&args(str)&&@annotation(ao)")
	public void dataFightArgsImput3(JoinPoint jp,MessAspectTest target,
									String str,MyAspectAn ao){
		System.out.println("dataFightArgsImput jp = "+String.valueOf(jp));
		System.out.println("dataFightArgsImput target = "+String.valueOf(target));
		System.out.println("dataFightArgsImput str = "+String.valueOf(str));
		System.out.println("dataFightArgsImput ao = "+String.valueOf(ao));
	}
	
//	@Before(value="target(target)&&this(myaop)")
//	@AfterReturning(value="target(target)&&this(myaop)")
	public void dataFightArgsImput4(JoinPoint jp,IReviewSkills target,
									Object myaop){
		System.out.println("dataFightArgsImput jp = "+String.valueOf(jp));
		System.out.println("dataFightArgsImput target = "+String.valueOf(target));
//		System.out.println("dataFightArgsImput myaop = "+myaop);
//		((IReviewSkills) myaop).recall("");
	}
//	@Around(value="target(target)&&args(str)")
	public void dataFightArgsImput3(ProceedingJoinPoint jp,MyReviewSkillsImpl target,
									String str){
		System.out.println("dataFightArgsImput jp = "+String.valueOf(jp));
		try {
			jp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			throw e;
		}
		System.out.println("dataFightArgsImput target = "+String.valueOf(target));
		System.out.println("dataFightArgsImput str = "+String.valueOf(str));
		
	}
	@AfterThrowing(value="target(target)",throwing="ex")
	public void exeException(JoinPoint jp,MessAspectTest target,
			Exception ex){
		System.out.println("exeException jp = "+String.valueOf(jp));
		System.out.println("exeException target = "+String.valueOf(target));
		System.out.println("exeException ex = "+String.valueOf(ex));
		System.out.println("exeException this = "+String.valueOf(this));
		this.recall();
	}
//	@DeclareParents(value="pers.bright.spring.annotation.aop.IReviewSkills,"
//			+ "pers.bright.spring.annotation.aop.IVisionGril",
//			defaultImpl=MyIVisionGril.class)
//	public IVisionGril vg;
	
	public void recall(){
		System.out.println(" fuck you !!!");
	}
}
