package cn.chan.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "music_singer")
public class Singer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer singerid;
    private String singername;
    private String sex;
    private String singerinfo;
    private String singerregion;
    private Integer singerattention;
    private String singerimage;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "singerid")
    private Set<Song> songSet = new HashSet<Song>();

    public Set<Song> getSongSet() {
        return songSet;
    }

    public void setSongSet(Set<Song> songSet) {
        this.songSet = songSet;
    }

    public Singer() {
    }

    public Integer getSingerid() {
        return singerid;
    }

    public void setSingerid(Integer singerid) {
        this.singerid = singerid;
    }

    public String getSingername() {
        return singername;
    }

    public void setSingername(String singername) {
        this.singername = singername;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSingerinfo() {
        return singerinfo;
    }

    public void setSingerinfo(String singerinfo) {
        this.singerinfo = singerinfo;
    }

    public String getSingerregion() {
        return singerregion;
    }

    public void setSingerregion(String singerregion) {
        this.singerregion = singerregion;
    }

    public Integer getSingerattention() {
        return singerattention;
    }

    public void setSingerattention(Integer singerattention) {
        this.singerattention = singerattention;
    }

    public String getSingerimage() {
        return singerimage;
    }

    public void setSingerimage(String singerimage) {
        this.singerimage = singerimage;
    }
}
