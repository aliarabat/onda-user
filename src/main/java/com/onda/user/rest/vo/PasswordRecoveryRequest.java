package com.onda.user.rest.vo;

public class PasswordRecoveryRequest {

    private Long userId;
    private String newPwd;
    private String newPwdConfirmation;

    public PasswordRecoveryRequest(Long userId, String newPwd, String newPwdConfirmation) {
        this.userId = userId;
        this.newPwd = newPwd;
        this.newPwdConfirmation = newPwdConfirmation;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    public String getNewPwdConfirmation() {
        return newPwdConfirmation;
    }

    public void setNewPwdConfirmation(String newPwdConfirmation) {
        this.newPwdConfirmation = newPwdConfirmation;
    }
}
