package cn.chan.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestIoC {


    @Test
    public void IocTest()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        StudentService studentService =new StudentService();
//        studentService.add();
        StudentService studentService = (StudentService) context.getBean("studentService");
        studentService.add();

    }
}
