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


    /**
     * 用户激活
     * @param userId
     * @param state
     */
    public void updateState(Integer userId,Boolean state);


    /**
     * 检查用户名是否存在
     * @param username
     * @return
     */
    public User checkUsername(String username);


    /**
     * 检查邮箱是否存在
     * @param email
     * @return
     */
    public User checkEmail(String email);

}
