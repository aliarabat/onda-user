/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onda.user.util;

import com.onda.user.model.User;

/**
 *
 * @author Xrio
 */
public class UserUtil {

    public static User encrypt(User user) {
        user.setPassword(StringUtil.hash(user.getPassword()));
        return user;

    }

    public static int check(String email, String password, User userFromDatabase) {
        if(StringUtil.isEmpty(email)){
            return -1;
        } else if(StringUtil.isEmpty(password)){
            return -2;
        }else if(ObjectUtil.isNull(userFromDatabase)){
            return -3;
        }else if (!(userFromDatabase.getEmail().equals(email) && userFromDatabase.getPassword().equals(StringUtil.hash(password)))) {
            return -4;
        }else{
            return 1;
        }        
    }
    
   
}
