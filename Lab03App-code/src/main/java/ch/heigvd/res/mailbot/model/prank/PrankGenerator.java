package ch.heigvd.res.mailbot.model.prank;

import ch.heigvd.res.mailbot.config.ConfigManager_I;
import ch.heigvd.res.mailbot.model.mail.Group;
import ch.heigvd.res.mailbot.model.mail.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class PrankGenerator {

    private ConfigManager_I configManager;

    private static final Logger LOG = Logger.getLogger(PrankGenerator.class.getName());
    public PrankGenerator(ConfigManager_I configManager){
        this.configManager = configManager;

    }

    public List<Group> generateGroups(List<Person> victims, int numberOfGroups) {
        List<Person> availableVictims = new ArrayList(victims);
        Collections.shuffle(availableVictims);
        List<Group> groups = new ArrayList<>();

        for (int i=0; i< numberOfGroups; i++) {
            Group group = new Group();
            groups.add(group);
        }

        int turn = 0;
        Group targetGroup;
        while (availableVictims.size() > 0) {
            targetGroup = groups.get(turn);
            turn = (turn + 1) % groups.size();
            Person victim = availableVictims.remove(0);
            targetGroup.addMember(victim) ;
        }

        return groups;
    }

    public List<Prank> generatePranks(){
        List<Prank> pranks = new ArrayList<>();

        List<String> messages = configManager.getMessages();
        List<Person> victims = configManager.getVictims();
        int numberOfGroups = configManager.getNumberOfGroup();
        int numberOfVictims = victims.size();

        if( numberOfVictims / numberOfGroups < 3){
            numberOfGroups = numberOfVictims / 3;
            LOG.warning("Not enough victims for the number of group set. victims"+ numberOfVictims + "Group generated: " + numberOfGroups);
        }

        List<Group> groups = generateGroups(victims, numberOfGroups);

        for(String msg : messages){
            System.out.println("/" + msg + "/");
        }
        int iMessage = 0;
        for(Group group : groups){
            Prank prank = new Prank();

            List<Person> members = group.getMembers();
            Collections.shuffle(members);
            Person sender = members.remove(0);
            prank.setSenderVictim(sender);
            prank.addVictimRecipients(members);

            prank.addWitnessRecipients(configManager.getWitnessToCC());


            String message = messages.get(iMessage);

            iMessage = (iMessage + 1) % messages.size();

            prank.setMessageBody(message);
            prank.setMessageSubject(message);
            pranks.add(prank);

        }

        return pranks;
    }



}
