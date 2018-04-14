/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.res.mailbot.smtp;

import ch.heigvd.res.mailbot.model.mail.Mail;

import java.io.IOException;

/**
 *
 * @author manalito
 */
public interface SmtpClient_I {
    public void sendMail(Mail mail) throws IOException;
}
