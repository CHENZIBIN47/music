package cn.chan.action;

import cn.chan.entity.Singer;
import cn.chan.entity.Song;
import cn.chan.service.SingerService;
import cn.chan.service.SongService;
import cn.chan.service.impl.SingerServiceImpl;
import cn.chan.service.impl.SongServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;


public class SongAction extends ActionSupport {

    private Song song;
    private List<Song> songList;
    private String sname;

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }

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


    /**
     * 遍历所有歌曲
     * @return
     */
    public String allSong()
    {
        songList = songService.findAll();


        return "allSong";


    }


    /**
     * 查找
     * @return
     */
    public String findSong()
    {

        songList = songService.fuzzyQuery(sname);
        return "findSong";

    }




}
