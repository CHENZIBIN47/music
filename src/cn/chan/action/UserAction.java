package cn.chan.action;


import cn.chan.entity.User;
import cn.chan.service.UserService;
import cn.chan.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class UserAction extends ActionSupport{

    UserService userService = new UserServiceImpl();
    private User user;
    private List<User> userList;
    private String username;
    private String email;
    private Integer uid;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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
    public String doRegist() throws Exception {


        HttpServletRequest request = ServletActionContext.getRequest();
        String verifyCode = (String) request.getSession().getAttribute("verifyCode");
        if(!verifyCode.equalsIgnoreCase(user.getVercode()))
        {

            request.setAttribute("verifyCodeError","验证码错误");
            request.setAttribute("user",user);
            return "doRegist";
        }
        else{
            userService.regist(user);
            final Properties props = new Properties();

            // 表示SMTP发送邮件，需要进行身份验证
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.host", "smtp.126.com");

            // 发件人的账号
            props.put("mail.user", "binter_chen@126.com");

            // 访问SMTP服务时需要提供的密码
            props.put("mail.password", "chen0337");

            // 构建授权信息，用于进行SMTP进行身份验证
            Authenticator authenticator = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    // 用户名、密码
                    String userName = props.getProperty("mail.user");
                    String password = props.getProperty("mail.password");
                    return new PasswordAuthentication(userName, password);
                }
            };

            /**
             * 用户注册时发送邮箱
             */
            // 使用环境属性和授权信息，创建邮件会话
            Session mailSession = Session.getDefaultInstance(props, authenticator);
            MimeMessage message = new MimeMessage(mailSession);
            InternetAddress fm = null;

                fm = new InternetAddress(props.getProperty("mail.user"));


            message.setFrom(fm);

            // 设置收件人
            InternetAddress to = new InternetAddress(user.getEmail());

            message.setRecipient(MimeMessage.RecipientType.TO, to);

            // 设置邮件标题
            message.setSubject("邮箱激活");
            message.setContent("<h1><a href='http://localhost:8080/"+"useractive.action?userid="+user.getUserid()+"'>点击完成激活</a></h1>", "text/html;charset=gbk");
//
            // 发送邮件
            Transport.send(message);
            return "doLogin";
        }

    }


    /**
     * 用户登录
     * @return
     */
    public String doLogin()
    {

        HttpServletRequest request = ServletActionContext.getRequest();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User form = new User(username,password);

        User user1 = userService.login(form);
        if(user1 == null)
        {
            request.setAttribute("mes","用户名或密码错误");
            request.setAttribute("user",form);
            return "toLogin";
        }else if (!user1.isState())
        {
            request.setAttribute("mes","您还没有激活");
            request.setAttribute("user",form);
            return "toLogin";

        } else {

            request.getSession().setAttribute("username",username);
            return "doLogin";
        }

    }


    /**
     * 用户激活
     * @return
     */
    public String active()
    {


        HttpServletRequest request = ServletActionContext.getRequest();
        String userid = request.getParameter("userid");
        Integer userId = Integer.parseInt(userid);
        userService.updateState(userId);
        request.setAttribute("mes", "激活成功");

        return "activation";
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


    /**
     * 检查用户名是否存在
     * @return
     */
    public String checkUsername() throws IOException {

        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
        User user = userService.checkUsername(username);
        if(user == null){

            response.getWriter().println("");

//            request.setAttribute("username","可以注册");

        }else {
            response.getWriter().println("已经被注册");
//            request.setAttribute("username","已经被注册了");
        }
        return NONE;
    }


    public String checkEmail() throws IOException {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");

        User user = userService.checkEmail(email);
        if(user == null){

            response.getWriter().println("");

        }else {

            response.getWriter().println("该邮箱已经被注册");
        }

        return NONE;
    }


    /**
     * 删除用户
     * @return
     */
    public String delUser()
    {
        userService.delUser(uid);
        return "deleteUser";

    }




}
