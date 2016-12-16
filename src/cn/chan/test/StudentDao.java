package cn.chan.test;

import org.springframework.stereotype.Component;

@Component(value = "studentDao")//相当于<bean id="userDao" class=""/>
public class StudentDao {


    public void add()
    {
        System.out.println("ass...........");
    }
}
