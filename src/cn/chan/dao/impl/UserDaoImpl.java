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

    /**
     * 用户激活
     * @param userId
     * @param state
     */
    @Override
    public void updateState(Integer userId, Boolean state) {

        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            User user = (User) session.get(User.class, userId);
            user.setState(true);
            session.update(user);


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

    /**
     *检查用户名是否存在
     * @param username
     * @return
     */
    @Override
    public User checkUsername(String username) {


        Session session = HibernateUtil.getSession();
        String hql = "from User u where u.username=:username";
        Query query = session.createQuery(hql);
        query.setString("username",username);
        User user = (User) query.uniqueResult();

        return user;

    }


    /**
     * 检查邮箱是否存在
     * @param email
     * @return
     */
    @Override
    public User checkEmail(String email) {


        Session session = HibernateUtil.getSession();
        String hql = "from User u where u.email=:email";
        Query query = session.createQuery(hql);
        query.setString("email",email);
        User user = (User) query.uniqueResult();

        return user;

    }


}
