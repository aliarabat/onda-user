/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onda.user.service;

import com.onda.user.model.User;
import com.onda.user.rest.vo.EmailChangeRequest;
import com.onda.user.rest.vo.PasswordChangeRequest;
import com.onda.user.rest.vo.PasswordRecoveryRequest;
import com.onda.user.rest.vo.UserDataChangeRequest;

/**
 *
 * @author Xrio
 */
public interface UserService {

    public int create(User user);

    public int edit(User user);

    public User findByEmailAndPassword(String email, String password);

    public User findByEmail(String email);

    public User login(String email, String password);

    public int userDataChange(UserDataChangeRequest userDataChangeRequest);

    public int emailChange(EmailChangeRequest emailChangeRequest);

    public int passwordChange(PasswordChangeRequest passwordChangeRequest);

    public int passwordRecover(PasswordRecoveryRequest passwordRecoveryRequest);
}
