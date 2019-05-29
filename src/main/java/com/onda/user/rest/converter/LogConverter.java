/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onda.user.rest.converter;

import com.onda.user.model.Log;
import com.onda.user.model.User;
import com.onda.user.rest.vo.LogVo;
import com.onda.user.rest.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Xrio
 */
@Component
public class LogConverter {

    @Autowired
    UserConverter userConverter;

    public Log toItem(LogVo logVo) {
        Long id = logVo.getId();
        User user = userConverter.toItem(logVo.getUserVo());
        String logDate = logVo.getLogDate();
        String body = logVo.getBody();

        return new Log(id, user, logDate, body);
    }

    public LogVo toVo(Log log) {
        Long id = log.getId();
        UserVo userVo = userConverter.toVo(log.getUser());
        String logDate = log.getLogDate();
        String body = log.getBody();

        return new LogVo(id, userVo, logDate, body);
    }

}
