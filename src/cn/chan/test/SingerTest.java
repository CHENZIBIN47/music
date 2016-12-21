package cn.chan.test;


import cn.chan.entity.Singer;
import cn.chan.service.SingerService;
import cn.chan.service.impl.SingerServiceImpl;
import org.junit.Test;

public class SingerTest {

    @Test
    public void addSingerTest()
    {
        SingerService singerService = new SingerServiceImpl();
        Singer singer = new Singer();
        singer.setSingername("chen");
        singer.setSex("nan");
        singer.setSingerinfo("sss");
        singer.setSingerregion("ccc");
        singerService.addSinger(singer);

    }

    @Test
    public void delete()
    {
        SingerService singerService = new SingerServiceImpl();
        singerService.delete(3);


    }





}
