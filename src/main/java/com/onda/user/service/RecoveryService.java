/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onda.user.service;

import com.onda.user.model.Recovery;
import com.onda.user.model.User;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author Xrio
 */
public interface RecoveryService {
     public int create(Recovery recovery);
     public int edit(Recovery recovery);
     public int sendAndNotify(String email);
     public int recover(String token);
     public int serve(Long id);
     public User getRecoveryUser(String token);
     public int remove(User user);

}
