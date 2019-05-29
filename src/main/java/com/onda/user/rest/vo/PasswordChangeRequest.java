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
public class PasswordChangeRequest {

    private Long userId;
    private String oldPassword;
    private String newPassword;

    public PasswordChangeRequest() {
    }

    public PasswordChangeRequest(Long id, String oldPassword, String newPassword) {
        this.userId = id;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
