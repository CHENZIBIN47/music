package cn.chan.dao;


import cn.chan.entity.Singer;

public interface SingerDao {


    /**
     * 添加歌手
     * @param singer
     */
    public void addSinger(Singer singer);


    /**
     * 删除歌手
     * @param singerid
     * @return
     */
    public Boolean delete(Integer singerid);

    /**
     * 查找歌手
     * @param singername
     * @return
     */
    public Singer findSinger(String singername);


}
