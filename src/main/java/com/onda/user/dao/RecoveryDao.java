/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onda.user.dao;

import com.onda.user.model.Recovery;
import com.onda.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 *
 * @author Xrio
 */
@Repository
public interface RecoveryDao extends JpaRepository<Recovery, Long> {
    public Recovery findByToken(String token);
    public Recovery findByUser(User user);

    @Modifying
    @Transactional
    @Query("delete from Recovery R where R.user = ?1")
    public int removeByUser(User user);
}
