/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onda.user.rest.vo;

/**
 *
 * @author Xrio
 */
public class LogVo {

    private Long id;
    private UserVo userVo;
    private String logDate;
    private String body;

    public LogVo() {
    }

    public LogVo(Long id, UserVo userVo, String logDate, String body) {
        this.id = id;
        this.userVo = userVo;
        this.logDate = logDate;
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserVo getUserVo() {
        return userVo;
    }

    public void setUserVo(UserVo userVo) {
        this.userVo = userVo;
    }

    public String getLogDate() {
        return logDate;
    }

    public void setLogDate(String logDate) {
        this.logDate = logDate;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
