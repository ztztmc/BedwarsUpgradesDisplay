package me.ztzt.bedwarsupgradesdisplay;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import java.util.Iterator;
import net.minecraft.client.Minecraft;
import java.util.Map;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class HUDRenderer
{
    @SubscribeEvent
    public void onRenderOverlay(final RenderGameOverlayEvent.Text event) {
        if (!ConfigManager.config.displayEnabled) {
            return;
        }
        final Minecraft mc = FMLClientHandler.instance().getClient();
        int yOffset = bwupgradesdisplay.showTitles ? 20 : 10;
        if (!UpgradeTracker.getUpgrades().isEmpty() && bwupgradesdisplay.showTitles) {
            mc.fontRendererObj.drawStringWithShadow("§c§lUpgrades §7(" + UpgradeTracker.getUpgrades().size() + ")", 10, 10, 16777215);
        }
        for (final Map.Entry<String, Integer> entry : UpgradeTracker.getUpgrades().entrySet()) {
            final String upgradeName = entry.getKey();
            final int upgradeTier = entry.getValue();
            if (upgradeTier == 0) {
                mc.fontRendererObj.drawStringWithShadow("- " + upgradeName, 10, yOffset, 16777215);
            }
            else {
                mc.fontRendererObj.drawStringWithShadow("- " + upgradeName + " " + upgradeTier, 10, yOffset, 16777215);
            }
            yOffset += 10;
        }
        if (!TrapTracker.getTraps().isEmpty() && bwupgradesdisplay.showTitles) {
            mc.fontRendererObj.drawStringWithShadow("§c§lTraps §7(" + TrapTracker.getTraps().size() + ")", 10, (yOffset + 20), 16777215);
        }
        int yOffsetTraps = bwupgradesdisplay.showTitles ? (yOffset + 30) : (yOffset + 20);
        for (final Map.Entry<String, Integer> entry2 : TrapTracker.getTraps().entrySet()) {
            final String trapName = entry2.getKey();
            final int trapCount = entry2.getValue();
            if (trapCount == 1) {
                mc.fontRendererObj.drawStringWithShadow("- " + trapName, 10, yOffsetTraps, 16777215);
            }
            else {
                mc.fontRendererObj.drawStringWithShadow("- " + trapName + " " + trapCount, 10, yOffsetTraps, 16777215);
            }
            yOffsetTraps += 10;
        }
    }
}
