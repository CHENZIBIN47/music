package cn.chan.service;


import cn.chan.entity.User;

public interface UserService {


    /**
     * 注册用户
     * @param user
     */
    public void regist(User user);


    /**
     * 用户登录
     * @param form
     * @return
     */
    public User login(User form);

}
