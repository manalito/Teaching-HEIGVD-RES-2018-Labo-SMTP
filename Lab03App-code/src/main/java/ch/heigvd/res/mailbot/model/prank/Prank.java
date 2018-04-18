package ch.heigvd.res.mailbot.model.prank;

import ch.heigvd.res.mailbot.model.mail.Mail;
import ch.heigvd.res.mailbot.model.mail.Person;

import java.util.ArrayList;
import java.util.List;

public class Prank {

    private Person senderVictim;
    private final List<Person> recipientsVictims = new ArrayList<>();
    private final List<Person> recipientsWitnesses = new ArrayList<>();

    private String messageSubject;
    private String messageBody;

    public Person getSenderVictim() {
        return senderVictim;
    }

    public void setSenderVictim(Person senderVictim){
        this.senderVictim = senderVictim;
    }

    public String getMessageSubject(){
        return messageBody;
    }

    public void setMessageSubject(String messageSubject){
        this.messageSubject = messageSubject;
    }

    public String getMessageBody(){
        return messageBody;
    }

    public void setMessageBody(String messageBody){
        this.messageBody = messageBody;
    }

    public void addVictimRecipients(List<Person> victims){
        this.recipientsVictims.addAll(victims);
    }
    public void addWitnessRecipients(List<Person> witnesses){
        this.recipientsWitnesses.addAll(witnesses);
    }

    public List<Person> getRecipientsWitnesses(){
        return new ArrayList<>(recipientsWitnesses);
    }
    public List<Person> getRecipientsVictims(){
        return new ArrayList<>(recipientsVictims);
    }

    public Mail generateMail(){
        ArrayList<String> toAddresses = new ArrayList<>();
        ArrayList<String> ccAddresses = new ArrayList<>();
        Mail mail = new Mail();


        mail.setFrom(senderVictim.getEmailAddress());
        for(Person victim : recipientsVictims){
            toAddresses.add(victim.getEmailAddress());
        }
        mail.setTo(toAddresses);


        if(recipientsWitnesses.size() > 0) {
            for (Person witness : recipientsWitnesses) {
                ccAddresses.add(witness.getEmailAddress());
                //System.out.println(witness.getEmailAddress());
            }
            mail.setCc(ccAddresses);
        }


        mail.setSubject(messageSubject);
        mail.setBody(messageBody);
        
        return mail;
    }
}
