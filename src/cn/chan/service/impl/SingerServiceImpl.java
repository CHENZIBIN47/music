package cn.chan.service.impl;


import cn.chan.dao.SingerDao;
import cn.chan.dao.impl.SingerDaoImpl;
import cn.chan.entity.Singer;
import cn.chan.service.SingerService;

import java.util.List;

public class SingerServiceImpl implements SingerService{

    SingerDao singerDao = new SingerDaoImpl();

    /**
     * 添加歌手
     * @param singer
     */
    @Override
    public void addSinger(Singer singer) {
        singerDao.addSinger(singer);

    }

    /**
     * 删除歌手
     * @param singerid
     * @return
     */
    @Override
    public Boolean delete(Integer singerid) {

        singerDao.delete(singerid);

        return null;
    }

    /**
     * 查找歌手
     * @param singername
     * @return
     */
    @Override
    public Singer findSinger(String singername) {

        Singer singer = singerDao.findSinger(singername);
        return singer;
    }

    /**
     * 查找所有歌手
     * @return
     */
    @Override
    public List<Singer> findAllSinger() {

        List<Singer> singerList = singerDao.findAllSinger();

        return singerList;
    }
}
