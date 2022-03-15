package com.service;

import com.dao.UserDao;
import com.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserDao userDao;

    @Autowired
    public void setUserDAO(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean hasMatch(String username,String password){
        int count=userDao.ValidUser(username,password);
        return count>0;
    }
}