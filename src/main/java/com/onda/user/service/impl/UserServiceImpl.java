/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onda.user.service.impl;

import com.onda.user.dao.UserDao;
import com.onda.user.model.User;
import com.onda.user.rest.vo.EmailChangeRequest;
import com.onda.user.rest.vo.PasswordChangeRequest;
import com.onda.user.rest.vo.PasswordRecoveryRequest;
import com.onda.user.rest.vo.UserDataChangeRequest;
import com.onda.user.service.LogService;
import com.onda.user.service.UserService;
import com.onda.user.util.StringUtil;
import com.onda.user.util.UserUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Xrio
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private LogService logService;

    @Override
    public int create(User user) {
        if (userDao.findByEmail(user.getEmail()) != null) {
            return -1;
        } else if (userDao.findByUsername(user.getUsername()) != null) {
            return -2;
        } else {
            userDao.save(UserUtil.encrypt(user));
            return 1;
        }
    }

    @Override
    public int edit(User user) {
        if (userDao.findByEmail(user.getEmail()) == null) {
            return -1;
        } else if (userDao.findByUsername(user.getUsername()) == null) {
            return -2;
        } else {
            userDao.save(user);
            return 1;
        }
    }

    @Override
    public User login(String email, String password) {
        User userFromDatabase = findByEmailAndPassword(email, password);
        if (UserUtil.check(email, password, userFromDatabase) < 0) {
            return null;
        } else {
            return userFromDatabase;
        }
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        if (StringUtil.isEmpty(email) || StringUtil.isEmpty(password)) {
            return null;
        } else {
            return userDao.findByEmailAndPassword(email, StringUtil.hash(password));
        }
    }

    @Override
    public int userDataChange(UserDataChangeRequest userDataChangeRequest) {
        User userFromDatabase = userDao.getOne(userDataChangeRequest.getUserId());
        if (userFromDatabase == null) {
            return -2;
        } else {
            userFromDatabase.setUsername(userDataChangeRequest.getUsername());
            userFromDatabase.setFirstName(userDataChangeRequest.getFirstName());
            userFromDatabase.setLastName(userDataChangeRequest.getLastName());
            userDao.save(userFromDatabase);
            return 1;
        }
    }

    @Override
    public int emailChange(EmailChangeRequest emailChangeRequest) {
        User userFromDatabase = userDao.findByEmail(emailChangeRequest.getOriginalEmail());
        if (userFromDatabase == null) {
            return -2;
        } else {
            userFromDatabase.setEmail(emailChangeRequest.getNewEmail());
            userDao.save(userFromDatabase);
            return 1;
        }
    }

    @Override
    public int passwordChange(PasswordChangeRequest passwordChangeRequest) {
        User userFromDatabase = userDao.getOne(passwordChangeRequest.getUserId());
        if (userFromDatabase == null) {
            return -2;
        } else if (!userFromDatabase.getPassword().equals(StringUtil.hash(passwordChangeRequest.getOldPassword()))) {
            return -3;
        } else {
            userFromDatabase.setPassword(StringUtil.hash(passwordChangeRequest.getNewPassword()));
            userDao.save(userFromDatabase);
            return 1;
        }
    }

    @Override
    public int passwordRecover(PasswordRecoveryRequest passwordRecoveryRequest) {
        User userFromDatabase = userDao.getOne(passwordRecoveryRequest.getUserId());
        if (userFromDatabase == null) {
            return -2;
        } else {
            userFromDatabase.setPassword(StringUtil.hash(passwordRecoveryRequest.getNewPwd()));
            userDao.save(userFromDatabase);
            return 1;
        }
    }

    @Override
    public User findByEmail(String email) {
        System.out.println(email);
        return userDao.findByEmail(email);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public LogService getLogService() {
        return logService;
    }

    public void setLogService(LogService logService) {
        this.logService = logService;
    }

}
