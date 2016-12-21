package cn.chan.action;


import cn.chan.entity.Singer;
import cn.chan.service.SingerService;
import cn.chan.service.impl.SingerServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class SingerAction extends ActionSupport{


    private Singer singer;

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    SingerService singerService = new SingerServiceImpl();

    public String add()
    {

        singerService.addSinger(singer);



        return "addSinger";
    }




}
