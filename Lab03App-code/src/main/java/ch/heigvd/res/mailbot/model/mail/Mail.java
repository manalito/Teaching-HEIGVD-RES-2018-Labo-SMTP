package ch.heigvd.res.mailbot.model.mail;

import java.util.ArrayList;

public class Mail {

    private String from = null;
    private ArrayList<String> to = null;
    private ArrayList<String> cc = null;
    private ArrayList<String> bcc = null;
    private String subject = null;
    private String body = null;


    public Mail(String fromAddress, ArrayList<String> toAddresses, String subject, String body){
        this.from = fromAddress;
        this.to = toAddresses;
        this.subject = subject;
        this.body = body;
    }

    public String getFrom(){
        return from;
    }

    public ArrayList<String> getTo(){
        return to;
    }
    public ArrayList<String> getCc(){
        return cc;
    }

    public ArrayList<String> getBcc(){
        return bcc;
    }

    public String getSubject(){
        return subject;
    }

    public String getBody(){
        return body;
    }

    public void setCc(ArrayList<String> ccAddresses){
        this.cc = ccAddresses;
    }

    public void setBcc(ArrayList<String> bccAddresses){
        this.bcc = bccAddresses;
    }

}
