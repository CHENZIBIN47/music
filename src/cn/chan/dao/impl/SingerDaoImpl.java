package cn.chan.dao.impl;

import cn.chan.dao.SingerDao;
import cn.chan.entity.Singer;
import cn.chan.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class SingerDaoImpl implements SingerDao {


    @Override
    public void addSinger(Singer singer) {


        Transaction tx = null;
        try {
            Session session = HibernateUtil.getSession();
            tx = session.beginTransaction();
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
}
