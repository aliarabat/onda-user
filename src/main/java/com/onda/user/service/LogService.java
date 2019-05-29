/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onda.user.service;

import com.onda.user.model.Log;

/**
 *
 * @author Xrio
 */
public interface LogService {

    public int create(Log log);

    public int edit(Log log);

}
