/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onda.user.rest;

import com.onda.user.model.Recovery;
import com.onda.user.model.User;
import com.onda.user.service.RecoveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Xrio
 */
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("user-api/recovery")
public class RecoveryRest {
    
    @Autowired
    private RecoveryService recoveryService;

//    @PostMapping("/serve")
//    public int serve(@RequestBody Long id){
//        return recoveryService.serve(id);
//    }

    @GetMapping("/get-email/{token}")
    public User getRecoveryEmail(@PathVariable String token){
        return recoveryService.getRecoveryEmail(token);
    }
    
    public RecoveryService getRecoveryService() {
        return recoveryService;
    }

    public void setRecoveryService(RecoveryService recoveryService) {
        this.recoveryService = recoveryService;
    }
    
    
}
