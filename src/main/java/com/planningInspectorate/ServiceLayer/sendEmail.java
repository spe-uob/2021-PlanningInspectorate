package com.planningInspectorate.ServiceLayer;

import com.planningInspectorate.ServiceLayer.emailUtil;

import javax.mail.Session;

import java.util.Properties;

import static javax.mail.Session.*;

public class sendEmail {

    public static class SimpleEmail {

        public static void main(String[] args) {

            System.out.println("SimpleEmail Start");

            String smtpHostServer = "smtp.example.com";
            String emailID = "email_me@example.com";

            Properties props = System.getProperties();

            props.put("mail.smtp.host", smtpHostServer);

            Session session = getInstance(props, null);

            emailUtil.sendEmail(session, emailID,"SimpleEmail Testing Subject", "SimpleEmail Testing Body");
        }

    }
}
