/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onda.user.service.impl;

import com.onda.user.dao.RecoveryDao;
import com.onda.user.model.Recovery;
import com.onda.user.model.User;
import com.onda.user.service.RecoveryService;
import com.onda.user.service.UserService;
import com.onda.user.smtp.EmailSender;
import com.onda.user.util.LinkUtil;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.Properties;

import com.onda.user.util.ObjectUtil;
import com.onda.user.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Xrio
 */
@Service
public class RecoveryServiceImpl implements RecoveryService {

    @Autowired
    private RecoveryDao recoveryDao;

    @Autowired
    private EmailSender emailSender;

    @Autowired
    private UserService userService;

    @Override
    public int sendAndNotify(String email) {
        User userFromDatabase = userService.findByEmail(email);
        if (userFromDatabase == null) {
            return -1;
        } else {
            String link = LinkUtil.generatePasswordRecoveryLink();
            String token = LinkUtil.generateToken(email);
            int result = emailSender.sendPasswordRecoveryEmail(email, link + token);
            if (result == 1) {
                recoveryDao.save(new Recovery(token, new Date().getTime(), userFromDatabase, "PASSWORD_FORGOTTEN_REQUEST"));
            }
            return result;
        }
    }

    @Override
    public int recover(String token) {
        Recovery recovery = recoveryDao.findByToken(token);
        if (recovery == null || new Date().getTime() - 86400000 > recovery.getLocalInstant()) {
            return -1;
        } else {
            //
            return 1;
        }
    }

    @Override
    public int serve(Long id) {
        Recovery recovery = recoveryDao.getOne(id);
        if (recovery == null) {
            return -1;
        } else {
            recovery.setIsServed(true);
            recoveryDao.save(recovery);
            return 1;
        }
    }

    @Override
    public User getRecoveryEmail(String token) {
        if (StringUtil.isEmpty(token)) {
            return null;
        } else {
            Recovery recovery =recoveryDao.findByToken(token);
            if(ObjectUtil.isNull(recovery)){
                return null;
            }
            return recoveryDao.findByToken(token).getUser();
        }
    }

    @Override
    public int create(Recovery recovery) {
        recoveryDao.save(recovery);
        return 1;
    }

    @Override
    public int edit(Recovery recovery) {
        recoveryDao.save(recovery);
        return 1;
    }

    public EmailSender getEmailSender() {
        return emailSender;
    }

    public void setEmailSender(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public RecoveryDao getRecoveryDao() {
        return recoveryDao;
    }

    public void setRecoveryDao(RecoveryDao recoveryDao) {
        this.recoveryDao = recoveryDao;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}
