/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onda.user.util;


/**
 * @author Xrio
 */
public class LinkUtil {


    public static final String ROOT_LINK = "http://localhost:4200/";

    public static String generateToken(String origin) {
        return StringUtil.hash(origin + Math.random());
    }

    public static String generatePasswordRecoveryLink() {
        return ROOT_LINK + "login/reinitialisation-de-mot-de-passe/changement-de-mot-de-passe/";
    }

}
