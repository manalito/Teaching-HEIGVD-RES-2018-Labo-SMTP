package ch.heigvd.res.mailbot.model.mail;

public class Person {

    private String firstName;
    private String lastName;

    private String emailAddress;

    public Person(String firstName, String lastName, String emailAddress){
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getEmailAddress(){
        return emailAddress;
    }
}
