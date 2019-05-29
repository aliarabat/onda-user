/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onda.user.dao;

import com.onda.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Xrio
 */
@Repository
public interface UserDao extends JpaRepository<User, Long> {

    public User findByEmailAndPassword(String email, String password);
    public User findByUsername(String username);
    public User findByEmail(String email);    
}
