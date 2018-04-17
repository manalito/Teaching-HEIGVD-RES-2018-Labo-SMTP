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
        SmtpClient client = new SmtpClient("localhost", 2525);

        Logger LOG = Logger.getLogger(client.getClass());
        /*ArrayList<String> victims = new ArrayList<>();
        victims.add("nathan.fluckiger@heig-vd.ch");
        victims.add("aurelsiu@hotmail.com");

        Mail m1 = new Mail("aurelien.siu@heig-vd.ch", victims, "SPAM", "Hello I am a spam");

        Mail m2 = new Mail("nathan.fluckiger@heig-vd.ch", victims, "News", "Hello, here I am");

        List<Person> lp = new ArrayList<>();

        lp.add(new Person("nathan.fluckiger@heig-vd.ch"));
        lp.add(new Person("aurelsiu@hotmail.com"));*/
        try{
            /*client.sendMail(m1);
            client.sendMail(m2);
            p.setSenderVictim(new Person("nathan.fluckiger@heig-vd.ch"));
            p.setMessageSubject("Hello, here I am");
            p.setMessageBody("Hi, I am steven");
            p.addVictimRecipients(lp);
            Mail m = p.generateMail();
            */

            ConfigManager cm = new ConfigManager();

            // TODO : read messages in ConfigManager and random in PrankGenerator Class

            PrankGenerator prankGenerator = new PrankGenerator(cm);
            List<Prank> pranks = prankGenerator.generatePranks();
            Mail mail;
            Prank p = new Prank();

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
