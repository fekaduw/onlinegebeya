package com.fekadu.onlinegebeya.service;


import com.fekadu.onlinegebeya.domain.Email;
import com.fekadu.onlinegebeya.domain.User;

public interface MailService {
    public void sendMail(Email email) throws Exception;
    public void sendMail(User receiver, String subject, String message);
}
