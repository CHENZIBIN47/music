package cn.chan.test;

import cn.chan.entity.Singer;
import cn.chan.entity.Song;
import cn.chan.entity.User;
import cn.chan.entity.UserCollection;
import cn.chan.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * Created by Administrator on 2016/12/14.
 */
public class OneToManyTest {


    /**
     * 一对多的级联添加
     */
    @Test
    public void OneToManyAdd()
    {

        Transaction tx = null;
        try {
            Session session = HibernateUtil.getSession();
            tx = session.beginTransaction();

            Singer singer = new Singer();
            singer.setSingername("陈奕迅");
            singer.setSex("男");
            singer.setSingerinfo("HongKong");


            Song song = new Song();

            song.setSongname("浮夸");
            song.setSingername("陈奕迅");


            singer.getSongSet().add(song);
            song.setSinger(singer);

            session.save(song);
            session.save(singer);
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
     * 一对多的级联删除
     */

    @Test
    public void OneToManyDel()
    {

        Transaction tx = null;
        try {
            Session session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            Singer singer = (Singer) session.get(Singer.class, 1);
            session.delete(singer);


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

    @Test
    public void OneToManyUser(){

        Transaction tx = null;
        try {
            Session session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            User user = new User();
            user.setUsername("ciao");
            user.setPassword("ddd");
            user.setRepassword("ddd");
            user.setSex("nv");
            user.setEmail("sssen@qq.com");

            UserCollection userCollection = new UserCollection();
            userCollection.setSingername("ch");
            userCollection.setSongname("vvv");
            userCollection.setUsername("cdd");

            user.getUserCollectionSet().add(userCollection);
            userCollection.setUser(user);
            session.save(user);
            session.save(userCollection);



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

}
