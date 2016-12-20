package cn.chan.dao.impl;


import cn.chan.dao.SongDao;
import cn.chan.entity.Song;
import cn.chan.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class SongDaoImpl implements SongDao{


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
}
