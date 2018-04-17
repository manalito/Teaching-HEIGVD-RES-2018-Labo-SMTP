package ch.heigvd.res.mailbot.model.mail;

import java.util.ArrayList;
import java.util.List;

public class Mail {

    private String from = null;
    private List<String> to = null;
    private List<String> cc = null;
    private List<String> bcc = null;
    private String subject = null;
    private String body = null;


    public Mail(String fromAddress, List<String> toAddresses, String subject, String body){
        this.from = fromAddress;
        this.to = toAddresses;
        this.subject = subject;
        this.body = body;
    }

    public Mail(){
    }

    public String getFrom(){
        return from;
    }

    public List<String> getTo(){
        return to;
    }
    public List<String> getCc(){return cc; }

    public List<String> getBcc(){
        return bcc;
    }

    public void setTo(ArrayList<String> toAddresses) {
        this.to = toAddresses;
    }

    public void setFrom(String fromAddress) {
        this.from = fromAddress;
    }

    public void setCc(List<String> ccAddresses){
        this.cc = ccAddresses;
    }
    public void setBcc(List<String> bccAddresses){
        this.bcc = bccAddresses;
    }


    public String getSubject(){
        return subject;
    }
    public String getBody(){
        return body;
    }

    public void setSubject(String subject) {this.subject = subject;}
    public void setBody(String body) {this.body = body;}
}
