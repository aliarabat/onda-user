/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onda.user.rest;

import com.onda.user.model.Recovery;
import com.onda.user.model.User;
import com.onda.user.rest.converter.UserConverter;
import com.onda.user.rest.validator.RequestBodyValidator;
import com.onda.user.rest.validator.UserValidator;
import com.onda.user.rest.vo.*;
import com.onda.user.service.RecoveryService;
import com.onda.user.service.UserService;
import com.onda.user.smtp.EmailSender;
import com.onda.user.util.LinkUtil;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @author Xrio
 */
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("user-api/user")
public class UserRest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private EmailSender emailSender;

    @Autowired
    private RecoveryService recoveryService;

    @PostMapping("/")
    public int create(@RequestBody UserVo userVo) {
        if (UserValidator.validateUserVo(userVo) < 0) {
            return -1;
        } else {
            return userService.create(userConverter.toItem(userVo));
        }
    }

    @PostMapping("/password-recovery")
    public int sendAndNotify(@RequestBody String email) {
        return recoveryService.sendAndNotify(email);
    }

    @GetMapping("/password-recovery-check/{token}")
    public int recover(@PathVariable String token) {
        return recoveryService.recover(token);
    }

    @PutMapping("/")
    public int edit(@RequestBody UserVo userVo) {
        if (UserValidator.validateUserVo(userVo) < 0) {
            return -1;
        } else {
            return userService.edit(userConverter.toItem(userVo));
        }
    }

    @PutMapping("/email")
    public int emailChange(@RequestBody EmailChangeRequest emailChangeRequest) {
        if (RequestBodyValidator.validateEmailChangeRequest(emailChangeRequest)) {
            return -1;
        } else {
            return userService.emailChange(emailChangeRequest);
        }
    }

    @PutMapping("/password")
    public int passwordChange(@RequestBody PasswordChangeRequest passwordChangeRequest) {
        if (RequestBodyValidator.validatePasswordChangeRequest(passwordChangeRequest)) {
            return -1;
        } else {
            return userService.passwordChange(passwordChangeRequest);
        }
    }

    @PutMapping("/password-recovery")
    public int passwordRecover(@RequestBody PasswordRecoveryRequest passwordRecoveryRequest) {
        if (RequestBodyValidator.validatePasswordRecoveryRequest(passwordRecoveryRequest)) {
            return -1;
        } else {
            return userService.passwordRecover(passwordRecoveryRequest);
        }
    }

    @PutMapping("/data")
    public int userDateChange(@RequestBody UserDataChangeRequest userDataChangeRequest) {
        if (RequestBodyValidator.validateUserDataChangeRequest(userDataChangeRequest)) {
            return -1;
        } else {
            return userService.userDataChange(userDataChangeRequest);
        }
    }

    @PostMapping("/login")
    public UserVo login(@RequestBody LoginRequest loginRequest) {
        if (RequestBodyValidator.validateLoginRequest(loginRequest)) {
            return null;
        } else {
            return userConverter.toVo(userService.login(loginRequest.getEmail(), loginRequest.getPassword()));
        }
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserConverter getUserConverter() {
        return userConverter;
    }

    public void setUserConverter(UserConverter userConverter) {
        this.userConverter = userConverter;
    }

    public EmailSender getEmailSender() {
        return emailSender;
    }

    public void setEmailSender(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public RecoveryService getRecoveryService() {
        return recoveryService;
    }

    public void setRecoveryService(RecoveryService recoveryService) {
        this.recoveryService = recoveryService;
    }
}
