/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onda.user.rest.validator;

import com.onda.user.model.User;
import com.onda.user.rest.vo.UserVo;
import com.onda.user.util.StringUtil;

/**
 *
 * @author Xrio
 */
public class UserValidator {

    public static int validateUser(User user) {
        if (user == null) {
            return -1;
        } else if (StringUtil.isEmpty(user.getUsername())) {
            return -2;
        } else if (StringUtil.isEmpty(user.getEmail())) {
            return -3;
        } else if (StringUtil.isEmpty(user.getPassword())) {
            return -4;
        } else if (StringUtil.isEmpty(user.getFirstName())) {
            return -5;
        } else if (StringUtil.isEmpty(user.getLastName())) {
            return -6;
        } else if (StringUtil.isEmpty(user.getBirthDate())) {
            return -7;
        } else if (StringUtil.isEmpty(user.getJoinDate())) {
            return -8;
        } else if (StringUtil.isEmpty(user.getRang())) {
            return -9;
        } else {
            return 1;
        }
    }

    public static int validateUserVo(UserVo userVo) {
        if (userVo == null) {
            return -1;
        } else if (StringUtil.isEmpty(userVo.getUsername())) {
            return -2;
        } else if (StringUtil.isEmpty(userVo.getEmail())) {
            return -3;
        } else if (StringUtil.isEmpty(userVo.getFirstName())) {
            return -5;
        } else if (StringUtil.isEmpty(userVo.getLastName())) {
            return -6;
        } else if (StringUtil.isEmpty(userVo.getRang())) {
            return -9;
        } else {
            return 1;
        }
    }
}
