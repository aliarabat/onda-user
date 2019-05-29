/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onda.user.rest.validator;

import com.onda.user.rest.vo.*;
import com.onda.user.util.StringUtil;

/**
 *
 * @author Xrio
 */
public class RequestBodyValidator {

    public static boolean validateLoginRequest(LoginRequest loginRequest) {
        return StringUtil.isEmpty(loginRequest.getEmail()) || StringUtil.isEmpty(loginRequest.getPassword());
    }
    
    public static boolean validateEmailChangeRequest(EmailChangeRequest emailChangeRequest){
        return StringUtil.isEmpty(emailChangeRequest.getNewEmail()) || StringUtil.isEmpty(emailChangeRequest.getOriginalEmail());
    }
    
    public static boolean validatePasswordChangeRequest(PasswordChangeRequest passwordChangeRequest){
        return StringUtil.isEmpty(passwordChangeRequest.getOldPassword()) || StringUtil.isEmpty(passwordChangeRequest.getNewPassword());
    }
    
    public static boolean validateUserDataChangeRequest(UserDataChangeRequest userDataChangeRequest){
        return StringUtil.isEmpty(userDataChangeRequest.getUsername()) || StringUtil.isEmpty(userDataChangeRequest.getLastName()) && StringUtil.isEmpty(userDataChangeRequest.getFirstName());
    }

    public static boolean validatePasswordRecoveryRequest(PasswordRecoveryRequest passwordRecoveryRequest){
        System.out.println(passwordRecoveryRequest.getUserId());
        System.out.println(passwordRecoveryRequest.getNewPwd());
        System.out.println(passwordRecoveryRequest.getNewPwdConfirmation());
        return StringUtil.isEmpty(passwordRecoveryRequest.getNewPwd()) || StringUtil.isEmpty(passwordRecoveryRequest.getNewPwdConfirmation());
    }
}
