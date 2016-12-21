package cn.chan.dao;


import cn.chan.entity.Song;

import java.util.List;

public interface SongDao {


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
     * 查询所有记录
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
