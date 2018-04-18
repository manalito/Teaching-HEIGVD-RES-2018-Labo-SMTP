package ch.heigvd.res.mailbot;

import ch.heigvd.res.mailbot.config.ConfigManager;
import ch.heigvd.res.mailbot.model.mail.Mail;
import ch.heigvd.res.mailbot.model.mail.Person;
import ch.heigvd.res.mailbot.model.prank.Prank;
import ch.heigvd.res.mailbot.model.prank.PrankGenerator;
import ch.heigvd.res.mailbot.smtp.SmtpClient;
import com.sun.istack.internal.logging.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class MailBot{


    public static void main(String [] args) {


        ConfigManager cm = new ConfigManager();
        SmtpClient client = new SmtpClient(cm.getServerAddress(), cm.getServerPort());
        Logger LOG = Logger.getLogger(client.getClass());


        try{


            PrankGenerator prankGenerator = new PrankGenerator(cm);

            List<Prank> pranks = prankGenerator.generatePranks();
            Mail mail;

            for(Prank prank : pranks){
                mail = prank.generateMail();
                // Test body presence LOG.info(mail.getBody());
                client.sendMail(mail);
            }
        } catch (IOException ex){
            LOG.severe(ex.getMessage());
        }


    }
}
