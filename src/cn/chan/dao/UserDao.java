package cn.chan.dao;


import cn.chan.entity.User;

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
}
