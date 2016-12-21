package cn.chan.dao.impl;


import cn.chan.dao.SongDao;
import cn.chan.entity.Song;
import cn.chan.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SongDaoImpl implements SongDao{

    /**
     * 添加歌曲
     * @param song
     */

    @Override
    public void addSong(Song song) {

        Transaction tx = null;
        try {
            Session session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            session.save(song);

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
     * 查询歌手、歌曲
     * @param singername
     * @return
     */
    @Override
    public List<Song> findSong(String singername) {

        Session session = HibernateUtil.getSession();
        String hql = "from Song s where s.singername=:singername or s.songname=:songname";
        Query query = session.createQuery(hql);
        query.setString("singername",singername);
        query.setString("songname",singername);
        List<Song> songList = query.list();


        return songList;
    }

    /**
     * 条件、模糊查询
     * @param sname
     * @return
     */
    @Override
    public List<Song> fuzzyQuery(String sname) {

        Session session = HibernateUtil.getSession();
        String hql = "from Song s where s.singername like ? or s.songname like ?";
        Query query = session.createQuery(hql);
        query.setString(0,"%"+sname+"%");
        query.setString(1,"%"+sname+"%");
        List<Song> songList = query.list();


        return songList;
    }

    /**
     * 查询所有歌曲
     * @return
     */
    @Override
    public List<Song> findAll() {

        Session session = HibernateUtil.getSession();
        String hql = "from Song";
        Query query = session.createQuery(hql);
        List<Song> songList = query.list();

        return songList;
    }


    /**
     * 删除歌曲
     * @param songid
     * @return
     */
    @Override
    public Boolean delete(Integer songid) {

        Transaction tx = null;
        try {
            Session session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            Song song = (Song) session.get(Song.class, songid);

            session.delete(song);

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


}
