package cn.chan.test;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component(value = "studentService")
public class StudentService {

    @Resource(name = "studentDao")
    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void add()
    {
        System.out.println("service........");
        studentDao.add();
    }
}
