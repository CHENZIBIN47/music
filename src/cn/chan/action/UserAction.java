package cn.chan.action;


import cn.chan.entity.User;
import cn.chan.service.UserService;
import cn.chan.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class UserAction extends ActionSupport{

    UserService userService = new UserServiceImpl();
    private User user;
    private List<User> userList;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
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

        HttpServletRequest request = ServletActionContext.getRequest();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User form = new User(username,password);

        User user1 = userService.login(form);
        if(user1 == null)
        {
            return "toLogin";
        }else {

            request.getSession().setAttribute("username",username);
            return "doLogin";
        }

    }


    /**
     * 查找所有的用户
     * @return
     */
    public String findAll()
    {


        userList = userService.findAll();
        return "allUser";
    }



}
