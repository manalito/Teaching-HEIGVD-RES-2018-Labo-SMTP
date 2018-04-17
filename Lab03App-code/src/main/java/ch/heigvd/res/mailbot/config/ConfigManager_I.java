
package ch.heigvd.res.mailbot.config;

import ch.heigvd.res.mailbot.model.mail.Mail;
import ch.heigvd.res.mailbot.model.mail.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author manalito
 */
public interface ConfigManager_I {

    public int getServerAddress();
    public int getServerPort();
    public  int getNumberOfGroup();

    public List<String> getWitnessToCC();

    public List<String> getMessages();

    public  List<Person> getVictims();
}
