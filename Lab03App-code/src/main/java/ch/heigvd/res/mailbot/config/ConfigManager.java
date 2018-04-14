/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.res.mailbot.config;

import ch.heigvd.res.mailbot.model.mail.Mail;

import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author manalito
 */
public class ConfigManager implements ConfigManager_I{



    public void setConfigFromFile(){
        Properties prop = new Properties();

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
}
