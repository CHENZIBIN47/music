package cn.chan.dao;


import cn.chan.entity.Song;

import java.util.List;

public interface SongDao {

    /**
     * 按歌手或歌曲的名称进行查找
     * @param singername
     * @return
     */
    public List<Song> findSong(String singername);


}
