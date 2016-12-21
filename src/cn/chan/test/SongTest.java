package cn.chan.test;


import cn.chan.entity.Singer;
import cn.chan.entity.Song;
import cn.chan.service.SingerService;
import cn.chan.service.SongService;
import cn.chan.service.impl.SingerServiceImpl;
import cn.chan.service.impl.SongServiceImpl;
import org.junit.Test;

import java.util.List;

public class SongTest {

    @Test
    public void find()
    {
        SongService songService = new SongServiceImpl();
        List<Song> songList = songService.findSong("cc");
        System.out.println(songList);
    }


    @Test
    public void fuzzyQueryTest()
    {
        SongService songService  = new SongServiceImpl();
        List<Song> songList = songService.fuzzyQuery("n");
        System.out.println(songList);


    }

    @Test
    public void queryAll()
    {
        SongService songService = new SongServiceImpl();
        List<Song> songList = songService.findAll();
        System.out.println(songList.size());


    }

    @Test
    public void delete()
    {
        SongService songService = new SongServiceImpl();
        songService.delete(1);
    }


    @Test
    public void findSingerId()
    {
        SingerService singerService = new SingerServiceImpl();
//        SongService songService = new SongServiceImpl();
        Singer singer = singerService.findSinger("chen");
        System.out.println(singer.getSingerid());


    }

    @Test
    public void modify()
    {
    	

    
    
    }

}
