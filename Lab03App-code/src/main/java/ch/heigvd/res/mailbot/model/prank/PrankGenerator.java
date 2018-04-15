package ch.heigvd.res.mailbot.model.prank;

import ch.heigvd.res.mailbot.config.ConfigManager_I;

import java.util.ArrayList;
import java.util.List;

public class PrankGenerator {

    private ConfigManager_I configManager;

    public PrankGenerator(ConfigManager_I configManager){
        this.configManager = configManager;
    }

    public List<Prank> generatePrank(){
        List<Prank> pranks = new ArrayList<>();

        List<String> messages;

        return pranks;
    }
}
