package cn.chan.service;


import cn.chan.entity.Song;

import java.util.List;

public interface SongService {



    /**
     * 添加歌曲
     * @param song
     */
    public void addSong(Song song);


    /**
     * 按歌手或歌曲的名称进行查找
     * @param singername
     * @return
     */
    public List<Song> findSong(String singername);


    /**
     * 条件查询、模糊查询
     *
     * @param sname
     * @return
     */
    public List<Song> fuzzyQuery(String sname);


    /**
     * 查询所有歌曲
     * @return
     */
    public List<Song> findAll();

    /**
     * 删除歌曲
     * @param songid
     * @return
     */
    public Boolean delete(Integer songid);

}
