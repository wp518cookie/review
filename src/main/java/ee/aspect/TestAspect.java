package ee.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


/**
 * Created by Administrator on 2018/3/22.
 */
@Aspect
@Component
public class TestAspect {
    @Before("execution(* ee.service.ITestService.*(..))")
    public void beforeMethod(JoinPoint joinPoint) {
        System.out.println(joinPoint.getTarget() + " start!");
    }
}
