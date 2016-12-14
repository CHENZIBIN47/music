package cn.chan.dao.impl;

import cn.chan.dao.UserDao;
import cn.chan.entity.User;
import cn.chan.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class UserDaoImpl implements UserDao {


    /**
     * 注册用户
     * @param user
     */
    public void regist(User user) {

        Transaction tx = null;
        try {
            Session session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            session.save(user);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            HibernateUtil.closeSession();
        }
    }


    /**
     * 用户登录
     * @param username
     * @return
     */

    public User login(String username) {


        Session session = HibernateUtil.getSession();
        String hql = "from User u where u.username=:username";
        Query query = session.createQuery(hql);
        query.setString("username",username);
        User user = (User) query.uniqueResult();

        return user;
    }


    /**
     * 查找所有的用户
     * @return
     */
    public List<User> findAll() {

        Session session = HibernateUtil.getSession();
        String hql = "from User ";
        Query query = session.createQuery(hql);
        List<User> userList = query.list();


        return userList;
    }


}
