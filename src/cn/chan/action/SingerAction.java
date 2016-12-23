package cn.chan.action;


import cn.chan.entity.Singer;
import cn.chan.service.SingerService;
import cn.chan.service.impl.SingerServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.util.List;

public class SingerAction extends ActionSupport{


    private Singer singer;
    private File photo;
    private String photoFileName;
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    private List<Singer> singerList;

    public List<Singer> getSingerList() {
        return singerList;
    }

    public void setSingerList(List<Singer> singerList) {
        this.singerList = singerList;
    }

    public File getPhoto() {
        return photo;
    }

    public void setPhoto(File photo) {
        this.photo = photo;
    }

    public String getPhotoFileName() {
        return photoFileName;
    }

    public void setPhotoFileName(String photoFileName) {
        this.photoFileName = photoFileName;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    SingerService singerService = new SingerServiceImpl();

    public String add()
    {

        if(photo != null)
        {
            String suffix = photoFileName.substring(photoFileName.lastIndexOf("."));
            String destFileName = System.currentTimeMillis()+suffix;
            singer.setSingerimage(destFileName);
            File destFile = new File(ServletActionContext.getServletContext().getRealPath("/")+"/music/files",destFileName);
            photo.renameTo(destFile);

        }else {
            singer.setSingerimage(null);
        }
        singerService.addSinger(singer);

        return "addSinger";
    }

    public String allSinger()
    {

        singerList = singerService.findAllSinger();

        if(result.equals("before")){
            return "beforeAllSinger";
        }else if(result.equals("after"))
        {
            return "afterAllSinger";
        }else {
            return NONE;
        }


        /*HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("singername",singerList);*/
    }




}
