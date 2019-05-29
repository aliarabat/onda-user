/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onda.user.rest.validator;

import com.onda.user.model.Log;
import com.onda.user.rest.vo.LogVo;
import com.onda.user.util.ObjectUtil;
import com.onda.user.util.StringUtil;


/**
 *
 * @author Xrio
 */
public class LogValidator {

    public static int validateLog(Log log) {
        if (ObjectUtil.isNull(log)) {
            return -1;
        } else if (UserValidator.validateUser(log.getUser()) < 0) {
            return -2;
        } else if (StringUtil.isEmpty(log.getLogDate())) {
            return -3;
        } else if (StringUtil.isEmpty(log.getBody())) {
            return -4;
        } else {
            return 1;
        }
    }

    public static int validateLogVo(LogVo logvo) {
        if (ObjectUtil.isNull(logvo)) {
            return -1;
        } else if (UserValidator.validateUserVo(logvo.getUserVo()) < 0) {
            return -2;
        } else if (StringUtil.isEmpty(logvo.getLogDate())) {
            return -3;
        } else if (StringUtil.isEmpty(logvo.getBody())) {
            return -4;
        } else {
            return 1;
        }
    }
}
