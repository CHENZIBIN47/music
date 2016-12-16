package cn.chan.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AddCustomer {

    @Before(value = "execution(* cn.chan.aop.Customer.*(..))")
    public void before()
    {
        System.out.println("before.........");
    }


    public void after()
    {
        System.out.println("after.........");
    }
}
