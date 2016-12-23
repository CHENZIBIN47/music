package cn.chan.dao.impl;

import cn.chan.dao.SingerDao;
import cn.chan.entity.Singer;
import cn.chan.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class SingerDaoImpl implements SingerDao {


    /**
     * 添加歌手
     * @param singer
     */
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

    /**
     * 删除歌手
     * @param singerid
     * @return
     */
    @Override
    public Boolean delete(Integer singerid) {

        Transaction tx = null;
        try {
            Session session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            Singer singer = (Singer) session.get(Singer.class,singerid);
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
        return null;
    }


    /**
     * 查找歌手
     * @param singername
     * @return
     */
    @Override
    public Singer findSinger(String singername) {

        Session session = HibernateUtil.getSession();
        String hql = "from Singer s where s.singername=:singername";
        Query query = session.createQuery(hql);
        query.setString("singername",singername);
        Singer singer = (Singer) query.uniqueResult();


        return singer;
    }


    /**
     * 查找所有歌手
     * @return
     */
    @Override
    public List<Singer> findAllSinger() {

        Session session = HibernateUtil.getSession();
        String hql = "from Singer";
        Query query = session.createQuery(hql);

        List<Singer> singerList = query.list();

        return singerList;
    }
}
