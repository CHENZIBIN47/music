package cn.chan.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestAop {

    @Test
    public void AopTest()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Customer customer = (Customer) context.getBean("customer");
        customer.add();
    }
}
