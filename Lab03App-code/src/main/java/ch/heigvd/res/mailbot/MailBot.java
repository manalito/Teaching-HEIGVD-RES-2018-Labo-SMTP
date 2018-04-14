package ch.heigvd.res.mailbot;

import ch.heigvd.res.mailbot.model.mail.Mail;
import ch.heigvd.res.mailbot.smtp.SmtpClient;
import com.sun.istack.internal.logging.Logger;

import java.io.IOException;
import java.util.ArrayList;

class MailBot{


    public static void main(String [] args) {
        SmtpClient client = new SmtpClient("localhost", 2525);

        Logger LOG = Logger.getLogger(client.getClass());
        ArrayList<String> victims = new ArrayList<>();
        victims.add("nathan.fluckiger@heig-vd.ch");
        victims.add("aurelsiu@hotmail.com");

        Mail m1 = new Mail("aurelien.siu@heig-vd.ch", victims, "SPAM", "Hello I am a spam");

        Mail m2 = new Mail("nathan.fluckiger@heig-vd.ch", victims, "News", "Hello, here I am");

        try{
            client.sendMail(m1);
            client.sendMail(m2);
        } catch (IOException ex){
            LOG.severe(ex.getMessage());
        }


    }
}
