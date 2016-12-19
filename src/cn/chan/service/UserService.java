package cn.chan.service;


import cn.chan.entity.User;

import java.util.List;

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

    /**
     * 查找所有的用户
     * @return
     */
    public List<User> findAll();



    /**
     * 用户激活
     * @param userId
     *
     */
    public void updateState(Integer userId);

}
