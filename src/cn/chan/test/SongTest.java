package cn.chan.test;


import cn.chan.entity.Song;
import cn.chan.service.SongService;
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
}
