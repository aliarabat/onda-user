/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onda.user.rest.converter;

import com.onda.user.model.User;
import com.onda.user.rest.validator.UserValidator;
import com.onda.user.rest.vo.UserVo;
import org.springframework.stereotype.Component;

/**
 *
 * @author Xrio
 */
@Component
public class UserConverter {

    public User toItem(UserVo userVo) {

        if (UserValidator.validateUserVo(userVo) < 0) {
            return null;
        } else {
            Long id = userVo.getId();
            String username = userVo.getUsername();
            String email = userVo.getEmail();
            String password = userVo.getPassword();
            String firstName = userVo.getFirstName();
            String lastName = userVo.getLastName();
            String birthDate = userVo.getBirthDate();
            String joinDate = userVo.getJoinDate();
            String rang = userVo.getRang();
            boolean isBlocked = userVo.getIsBlocked();

            return new User(id, username, email, password, firstName, lastName, birthDate, joinDate, rang,isBlocked);

        }
    }

    public UserVo toVo(User user) {

        if (UserValidator.validateUser(user) < 0) {
            return null;
        } else {
            Long id = user.getId();
            String username = user.getUsername();
            String email = user.getEmail();
            String password = null;
            String firstName = user.getFirstName();
            String lastName = user.getLastName();
            String birthDate = user.getBirthDate();
            String joinDate = user.getJoinDate();
            String rang = user.getRang();
            boolean isBlocked = user.isBlocked();

            return new UserVo(id, username, email, password, firstName, lastName, birthDate, joinDate, rang, isBlocked);
        }
    }
}
