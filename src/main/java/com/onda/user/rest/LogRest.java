/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onda.user.rest;

import com.onda.user.rest.converter.LogConverter;
import com.onda.user.rest.validator.LogValidator;
import com.onda.user.rest.vo.LogVo;
import com.onda.user.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Xrio
 */
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("user-api/log")
public class LogRest {

    @Autowired
    private LogService logService;

    @Autowired
    private LogConverter logConverter;

    @PostMapping("/")
    public int create(LogVo logVo) {
        if (LogValidator.validateLogVo(logVo) < 0) {            
            return -1;
        } else {
            return logService.create(logConverter.toItem(logVo));
        }
    }

    @PutMapping("/")
    public int edit(LogVo logVo) {
        if (LogValidator.validateLogVo(logVo) < 0) {
            return -1;
        } else {
            return logService.edit(logConverter.toItem(logVo));
        }
    }

    public LogService getLogService() {
        return logService;
    }

    public void setLogService(LogService logService) {
        this.logService = logService;
    }

    public LogConverter getLogConverter() {
        return logConverter;
    }

    public void setLogConverter(LogConverter logConverter) {
        this.logConverter = logConverter;
    }

}
