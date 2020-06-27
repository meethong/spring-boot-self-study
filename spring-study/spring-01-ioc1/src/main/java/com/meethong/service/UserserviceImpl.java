package com.meethong.service;

import com.meethong.dao.UserDao;
import com.meethong.dao.UserDaoImpl;
import com.meethong.dao.UserDaoMysqlimpl;

public class UserserviceImpl implements  UserService{

    UserDao userDao=new UserDaoImpl();



    // 利用set实现
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void getUser() {
    userDao.getUser();
    }
}
