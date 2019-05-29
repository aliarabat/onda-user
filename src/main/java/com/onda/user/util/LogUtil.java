/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onda.user.util;

import com.onda.user.model.Log;
import com.onda.user.model.User;
import java.util.Date;

/**
 *
 * @author Xrio
 */
public class LogUtil {
    
    public static Log build(User user, String body) {
        return new Log(user, String.valueOf(new Date()), body);
    }
    
}
