package io.github.ardeon.altar;

import org.bukkit.configuration.file.FileConfiguration;

public class AltarText {
    private final String PATH = "text.";

    private final String CHARGE = PATH + "charge";
    private final String DISCHARGED = PATH + "discharged";
    private final String DISCHARGEDMESSAGE = PATH + "dischargedmessage";
    private final String BROADCAST = PATH + "broadcast";

    private FileConfiguration config;

    public String getChargeText() {
        return chargeText;
    }

    public String getDischargedText() {
        return dischargedText;
    }

    public String getDischargedMessageText() {
        return dischargedMessageText;
    }

    public String getBroadcastText() {
        return broadcastText;
    }

    private String chargeText;
    private String dischargedText;
    private String dischargedMessageText;
    private String broadcastText;

    public AltarText(){
        config = AltarPlugin.getInstance().getConfig();
        reload();
    }

    public void reload(){
        chargeText = config.getString(CHARGE, "charge");
        dischargedText = config.getString(DISCHARGED, "discharged");
        dischargedMessageText = config.getString(DISCHARGEDMESSAGE, "dischargedmessage");
        broadcastText = config.getString(BROADCAST, "broadcast");
    }
}
