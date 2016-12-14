package cn.chan.dao;


import cn.chan.entity.User;

import java.util.List;

public interface UserDao {

    /**
     * 注册用户
     * @param user
     */
    public void regist(User user);


    /**
     * 用户登录
     * @param username
     * @return
     */
    public User login(String username);


    /**
     * 查找所有的用户
     * @return
     */
    public List<User> findAll();

}
