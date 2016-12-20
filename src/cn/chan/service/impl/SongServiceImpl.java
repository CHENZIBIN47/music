package cn.chan.service.impl;


import cn.chan.dao.SongDao;
import cn.chan.dao.impl.SongDaoImpl;
import cn.chan.entity.Song;
import cn.chan.service.SongService;

import java.util.List;

public class SongServiceImpl implements SongService{


    SongDao songDao = new SongDaoImpl();

    @Override
    public List<Song> findSong(String singername) {
        List<Song> songList = songDao.findSong(singername);
        return songList;
    }
}
