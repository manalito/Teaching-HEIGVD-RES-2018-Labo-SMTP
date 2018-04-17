/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.res.mailbot.config;


import java.io.*;
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

    public ConfigManager(){
        prop = new Properties();

        try {
            //load a properties file from class path, inside static method
            prop.load(ConfigManager.class.getResourceAsStream("config.properties"));

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

    public List<String> getWitnessToCC(){
        List<String> returnvalues = new ArrayList<>();
        String valueToParse = prop.getProperty("witnessestoCC");
        while(valueToParse.indexOf(",") > -1){
            returnvalues.add(valueToParse.substring(0, valueToParse.indexOf(",")));
            valueToParse = valueToParse.substring(valueToParse.indexOf(",")+1);
        }
        returnvalues.add(valueToParse);


        return returnvalues;
    }

    public List<String> getMessages(){
           List<String> returnValue = new ArrayList<String>();
            try {
                BufferedReader bReader = new BufferedReader(new InputStreamReader(new FileInputStream("messages.utf8"), "UTF-8"));

                String line;
                while ((line = bReader.readLine()) != null){
                    String str = "";
                    if(line.contains("Subject:")){
                        line.replace("Subject:","");
                        returnValue.add(line);
                    }else {
                        if(!line.contains("**")){
                            if(!line.equals("")) str += line + "\r" + "\n";
                        }
                        else{
                            returnValue.add(str);
                            str = "";
                        }
                    }
                }
            }catch (IOException e){
                System.out.println(e.getMessage());
            }

           return returnValue;
    }

    public  List<Person> getVictims(){
        List<Person> returnValue = new ArrayList<>();

        try {
            BufferedReader bReader = new BufferedReader(new InputStreamReader(new FileInputStream("victimes.utf8"), "UTF-8"));

            String line;
            while ((line = bReader.readLine()) != null){
               String firstname =  line.substring(0,line.indexOf("."));
               String lastname = line.substring(line.indexOf(".")+1, line.indexOf("@"));

               returnValue.add(new Person(firstname, lastname, line));
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        return returnValue;
    }
}
