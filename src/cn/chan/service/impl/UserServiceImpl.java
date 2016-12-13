package cn.chan.service.impl;

import cn.chan.dao.UserDao;
import cn.chan.dao.impl.UserDaoImpl;
import cn.chan.entity.User;
import cn.chan.service.UserService;


public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();


    /**
     * 注册用户
     * @param user
     */
    public void regist(User user) {
        userDao.regist(user);
    }

    /**
     * 用户登录
     * @param form
     * @return
     */
    public User login(User form) {

        User user = userDao.login(form.getUsername());
        if(user == null)return null;
        if(!user.getPassword().equals(form.getPassword()))return null;

        return user;
    }
}
