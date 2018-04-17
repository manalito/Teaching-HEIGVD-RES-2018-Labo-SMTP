/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.res.mailbot.config;

import ch.heigvd.res.mailbot.model.mail.Mail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.List;
import ch.heigvd.res.mailbot.model.mail.Person;

/**
 *
 * @author manalito
 */
public class ConfigManager implements ConfigManager_I{

    private Properties prop;

    public void setConfigFromFile(){
        prop = new Properties();

        try {
            //load a properties file from class path, inside static method
            prop.load(ConfigManager.class.getResourceAsStream("config.properties"));

            // Tests print configs
            //get the property value and print it out
            System.out.println(prop.getProperty("smtpServerAddress"));
            System.out.println(prop.getProperty("smtpServerPort"));
            System.out.println(prop.getProperty("numberOfGroup"));

            // TODO Set properties

        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public int getServerAddress(){
        return Integer.valueOf( prop.getProperty("smtpServerAddress"));
    }
    public int getServerPort(){
        return Integer.valueOf( prop.getProperty("smtpServerPort"));
    }

    public  int getNumberOfGroup(){
        return Integer.valueOf( prop.getProperty("numberOfGroup"));
    }

    public String getWitnessToCC(){
        return prop.getProperty("witnessestoCC");
    }

    public List<String> getMessages(){
           List<String> returnValue = new ArrayList<String>();



           return returnValue;
    }

    public  List<Person> getVictims(){
        List<Person> returnValue = new ArrayList<Person>();



        return returnValue;
    }
}
