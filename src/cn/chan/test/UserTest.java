package cn.chan.test;


import cn.chan.entity.User;
import cn.chan.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.List;

public class UserTest {

    @Test
    public void add()
    {

        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSession();

            transaction = session.beginTransaction();
            User user = new User();

            user.setUsername("kkkk");
            user.setPassword("123");
            user.setRepassword("123");
            user.setSex("nv");
            user.setRepassword("123");
            user.setEmail("123@QQ.COM");
//            user.setCode("adadfadf");
//            user.setState(true);

            session.save(user);



            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            HibernateUtil.closeSession();
        }
    }


    @Test
    public  void login()
    {
        Session session = HibernateUtil.getSession();
        String hql ="from User u where u.username=:username";
        Query query = session.createQuery(hql);
        query.setString("username","chen");
        User user = (User) query.uniqueResult();
        System.out.println(user.getPassword());

    }


    @Test
    public void findAll()
    {
        Session session = HibernateUtil.getSession();
        String hql = "from User ";
        Query query = session.createQuery(hql);
        List<User> userList = query.list();
        for (User user :userList) {
            System.out.println(user.getUsername());
        }


    }
}
