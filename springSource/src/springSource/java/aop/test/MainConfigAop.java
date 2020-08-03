package aop.test;

import org.junit.Test;
import org.springframework.context.annotation.*;




/*
 * @Description //TODO
 * AOP：【动态代理】，指定程序运行期间将某段代码切入到指定方法指定位置进行运行的编程方式
 * 1、导入aop spring-aspects
 * 2、定义业务逻辑类，在业务运行时将日志进行打印
 * 3、定义一个日志切面类，需要动态的感知程序运行到什么位置了。
 *          通知
 *              前置：(@Before)logStart运行之前
 *              后置:（@After）
 *              返回：(AfterReturning)logReturn 正常返回时执行
 *              异常：(AfterThrowing)logException 在程序运行出现异常后运行
 *              环绕：(Around)动态代理，手动推进目标方法运行（joinPoint,procced()）
 * 4、给切面类写注解
 * 5、将切面类和业务逻辑类添加到容器中
 * 6、必须告诉spring那个类是切面类，添加注解@Aspect
 * 7、添加EnableAspectJAutoProxy启动基于注解的aop
 *
 *
 * 一共分为三步
 * 1、将业务组建和切面类都添加到容器中，告诉Spring哪个是切面类（@Aspect）
 * 2、在切面类上的每一个通知方法上标注通知注解，告诉Spring何时何地运行（切入点表达式）
 * 3、开启基于注解的aop模式（@EnableAspectJAutoProxy）
 **/

@EnableAspectJAutoProxy
@Configuration
public class MainConfigAop {

    @Bean
    public MathCalculator calculator(){
        return new MathCalculator();
    }

    @Bean
    public LogAspect logAspect(){
        return new LogAspect();
    }
}
