/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onda.user.service.impl;

import com.onda.user.dao.LogDao;
import com.onda.user.model.Log;
import com.onda.user.rest.validator.LogValidator;
import com.onda.user.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Xrio
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDao logDao;

    @Override
    public int create(Log log) {
        logDao.save(log);
        return 1;
    }

    @Override
    public int edit(Log log) {
        logDao.save(log);
        return 1;
    }

    public LogDao getLogDao() {
        return logDao;
    }

    public void setLogDao(LogDao logDao) {
        this.logDao = logDao;
    }

}
