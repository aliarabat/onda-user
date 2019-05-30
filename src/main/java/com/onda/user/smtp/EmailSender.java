/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onda.user.smtp;

import com.onda.user.util.LinkUtil;
import com.onda.user.util.StringUtil;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.security.auth.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

/**
 * @author Xrio
 */
@Component
public class EmailSender {

    @Autowired
    private JavaMailSender javaMailSender;

    public int sendPasswordRecoveryEmail(String destination, String link) {
        String subject = "Demande de réinitialisation du mot de passe";
        String body = "Bonjour, suite à votre demande, nous vous envoyons un lien temporaire (24H)\n : " + link;
        return sendMessage(destination, subject, body);
    }

    public int sendPasswordChangeInformationMessage(String destination) {
        String subject = "Changement de mot de passe";
        String body = "Nous vous informons du changement de votre mot de passe. Si ce n'était pas suite à votre demande, veuillez contacter l'administrateur le plus rapidement possible.";
        return sendMessage(destination, subject, body);
    }

    public int sendEmailChangeInformationMessage(String destination) {
        String subject = "Changement d'adresse email";
        String body = "Nous vous informons du changement de votre adresse email. Si ce n'était pas suite à votre demande, veuillez contacter l'administrateur le plus rapidement possible.";
        return sendMessage(destination, subject, body);
    }

    public int sendMessage(String destination, String subject, String body) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper;
            helper = new MimeMessageHelper(message, true);
            helper.setSubject(subject);
            helper.setTo(destination);
            helper.setText(body, true);
            javaMailSender.send(message);
            return 1;
        } catch (MessagingException e) {
            return -2;
        } catch (Exception e) {
            return -3;
        }
    }

    public JavaMailSender getJavaMailSender() {
        return javaMailSender;
    }

    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

}
