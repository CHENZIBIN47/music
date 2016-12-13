package cn.chan.action;


import cn.chan.entity.User;
import cn.chan.service.UserService;
import cn.chan.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

public class UserAction extends ActionSupport{

    UserService userService = new UserServiceImpl();
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



    public String toRegist()
    {


        return "toregist";
    }

    /**
     * 用户注册
     * @return
     */
    public String doRegist()
    {

        userService.regist(user);
        return "doRegist";
    }


    public String doLogin()
    {

//        User user = userService.login(this.user);
        HttpServletRequest request = ServletActionContext.getRequest();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User form = new User(username,password);

        User user1 = userService.login(form);
        if(user1 == null)
        {
            return "toLogin";
        }else {

            return "doLogin";
        }

    }



}
