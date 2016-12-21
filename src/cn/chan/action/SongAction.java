package cn.chan.action;

import cn.chan.entity.Singer;
import cn.chan.entity.Song;
import cn.chan.service.SingerService;
import cn.chan.service.SongService;
import cn.chan.service.impl.SingerServiceImpl;
import cn.chan.service.impl.SongServiceImpl;
import com.opensymphony.xwork2.ActionSupport;


public class SongAction extends ActionSupport {

    private Song song;

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    SongService songService = new SongServiceImpl();


    public String add()
    {

        SingerService singerService = new SingerServiceImpl();
        Singer singer = singerService.findSinger(song.getSingername());

        if(singer == null){
            song.setSingerid(null);
        }else{

            song.setSingerid(singer.getSingerid());
        }

        songService.addSong(song);


        return "addSong";
    }


}
