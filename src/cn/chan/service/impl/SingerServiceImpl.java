package cn.chan.service.impl;


import cn.chan.dao.SingerDao;
import cn.chan.dao.impl.SingerDaoImpl;
import cn.chan.entity.Singer;
import cn.chan.service.SingerService;

public class SingerServiceImpl implements SingerService{

    SingerDao singerDao = new SingerDaoImpl();

    @Override
    public void addSinger(Singer singer) {
        singerDao.addSinger(singer);

    }
}
