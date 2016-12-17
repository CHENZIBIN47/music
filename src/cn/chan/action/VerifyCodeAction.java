package cn.chan.action;

import cn.chan.utils.VerifyCode;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.awt.image.BufferedImage;


public class VerifyCodeAction extends ActionSupport {




    @Override
    public String execute() throws Exception {

        VerifyCode verifyCode = new VerifyCode();

        BufferedImage image = verifyCode.getImage();

        ServletActionContext.getRequest().getSession().setAttribute("verifyCode",verifyCode.getText());

        VerifyCode.output(image,ServletActionContext.getResponse().getOutputStream());
        return NONE;
    }
}
