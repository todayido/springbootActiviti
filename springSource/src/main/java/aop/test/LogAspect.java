package aop.test;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class LogAspect {

    @Pointcut("execution (public int aop.test.MathCalculator.*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName());
        for (int i = 0; i < joinPoint.getArgs().length; i++) {
            System.out.println(joinPoint.getArgs()[i]);
        }
        System.out.println("除法运行");
    }

    @After("pointCut()")
    public void logEnd(){
        System.out.println("除法结束");
    }

    @AfterThrowing("pointCut()")
    public void logException(){
        System.out.println("除法异常");
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturning(Object result){
        System.out.println("Returning"+result);
    }
}
