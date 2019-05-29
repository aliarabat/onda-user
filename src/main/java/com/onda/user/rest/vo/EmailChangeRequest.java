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
public class EmailChangeRequest {

    private String originalEmail;
    private String newEmail;

    public EmailChangeRequest() {
    }

    public EmailChangeRequest(String oldEmail, String newEmail) {
        this.originalEmail = oldEmail;
        this.newEmail = newEmail;
    }

    public String getOriginalEmail() {
        return originalEmail;
    }

    public void setOriginalEmail(String originalEmail) {
        this.originalEmail = originalEmail;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }

}
