package ch.heigvd.res.mailbot.model.prank;

import ch.heigvd.res.mailbot.model.mail.Person;

import java.util.ArrayList;
import java.util.List;

public class Prank {

    private Person senderVictim;
    private final List<Person> recipientsVictims = new ArrayList<>();
    private final List<Person> recipientsWitness = new ArrayList<>();

    private String message;

    public Person getSenderVictim() {
        return senderVictim;
    }

    public void setSenderVictim(Person senderVictim){
        this.senderVictim = senderVictim;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String Message){
        this.message = message;
    }
}
