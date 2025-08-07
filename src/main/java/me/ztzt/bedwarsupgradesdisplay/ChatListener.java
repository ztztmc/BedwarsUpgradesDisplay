package me.ztzt.bedwarsupgradesdisplay;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.client.event.ClientChatReceivedEvent;

public class ChatListener
{
    @SubscribeEvent
    public void onChatReceived(final ClientChatReceivedEvent event) {
        final String message = event.message.getUnformattedText();
        if (message.contains("Sending you to") || message.contains("You are now connected to") || message.contains("1st Killer") || message.contains("joined the lobby!")) {
            System.out.println("[ztzt mods/" + bwupgradesdisplay.MODID + "] Detected new game or lobby. Resetting upgrades.");
            UpgradeTracker.getUpgrades().clear();
            TrapTracker.getTraps().clear();
        }
        this.processUpgrade(message);
    }

    private void processUpgrade(final String message) {
        if (message.contains("Sharpened Swords")) {
            UpgradeTracker.addOrUpdateUpgrade("Sharpened Swords", 0);
        }
        if (message.contains("Reinforced Armor") && message.endsWith("I")) {
            UpgradeTracker.addOrUpdateUpgrade("Reinforced Armor", 1);
        }
        if (message.contains("Reinforced Armor") && message.endsWith("II")) {
            UpgradeTracker.addOrUpdateUpgrade("Reinforced Armor", 2);
        }
        if (message.contains("Reinforced Armor") && message.endsWith("III")) {
            UpgradeTracker.addOrUpdateUpgrade("Reinforced Armor", 3);
        }
        if (message.contains("Reinforced Armor") && message.endsWith("IV")) {
            UpgradeTracker.addOrUpdateUpgrade("Reinforced Armor", 4);
        }
        if (message.contains("Maniac Miner") && message.endsWith("I")) {
            UpgradeTracker.addOrUpdateUpgrade("Maniac Miner", 1);
        }
        if (message.contains("Maniac Miner") && message.endsWith("II")) {
            UpgradeTracker.addOrUpdateUpgrade("Maniac Miner", 2);
        }
        if (message.contains("Iron Forge")) {
            UpgradeTracker.addOrUpdateUpgrade("Iron Forge", 0);
        }
        if (message.contains("Golden Forge")) {
            UpgradeTracker.addOrUpdateUpgrade("Golden Forge", 0);
        }
        if (message.contains("Emerald Forge")) {
            UpgradeTracker.addOrUpdateUpgrade("Emerald Forge", 0);
        }
        if (message.contains("Molten Forge")) {
            UpgradeTracker.addOrUpdateUpgrade("Molten Forge", 0);
        }
        if (message.contains("Heal Pool")) {
            UpgradeTracker.addOrUpdateUpgrade("Heal Pool", 0);
        }
        if (message.contains("Heal Pool")) {
            UpgradeTracker.addOrUpdateUpgrade("Heal Pool", 0);
        }
        if (message.contains("It's a trap!")) {
            TrapTracker.addOrUpdateTrap("It's a trap!");
        }
        if (message.contains("Alarm Trap")) {
            TrapTracker.addOrUpdateTrap("Reveal Trap");
        }
        if (message.contains("Counter-Offensive Trap")) {
            TrapTracker.addOrUpdateTrap("Counter-Offensive Trap");
        }
        if (message.contains("Miner Fatigue Trap")) {
            TrapTracker.addOrUpdateTrap("Miner Fatigue Trap");
        }
        if (message.contains("Miner Fatigue Trap was set off!")) {
            TrapTracker.removeTrap("Miner Fatigue Trap");
        }
        if (message.contains("It's a trap! was set off!")) {
            TrapTracker.removeTrap("It's a trap!");
        }
        if (message.contains("Reveal Trap was set off!")) {
            TrapTracker.removeTrap("Reveal Trap");
        }
        if (message.contains("Counter-Offensive Trap was set off!")) {
            TrapTracker.removeTrap("Counter-Offensive Trap");
        }
    }
}
