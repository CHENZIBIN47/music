package cn.chan.service.impl;

import cn.chan.dao.UserDao;
import cn.chan.dao.impl.UserDaoImpl;
import cn.chan.entity.User;
import cn.chan.service.UserService;

import java.util.List;


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

    /**
     * 查找所有的用户
     * @return
     */
    public List<User> findAll() {
        List<User> userList = userDao.findAll();

        return userList;
    }


    /**
     * 用户激活
     * @param userId
     */
    @Override
    public void updateState(Integer userId) {
        userDao.updateState(userId,true);
    }


    /**
     * 检查用户是否存在
     * @param username
     * @return
     */
    @Override
    public User checkUsername(String username) {

        User user = userDao.checkUsername(username);
        if(user == null)
        {

            return null;
        }else{
            return user;
        }
    }


    /**
     * 验证邮箱是否存在
     * @param email
     * @return
     */
    @Override
    public User checkEmail(String email) {

        User user = userDao.checkEmail(email);
        if(user == null)
        {
            return null;
        }else {

            return user;
        }
    }

    /**
     *
     * @param uid
     * @return
     */
    @Override
    public Boolean delUser(Integer uid) {

        try {
            userDao.delUser(uid);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
