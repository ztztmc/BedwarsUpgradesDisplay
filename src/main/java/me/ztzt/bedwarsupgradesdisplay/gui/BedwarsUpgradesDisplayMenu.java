package me.ztzt.bedwarsupgradesdisplay.gui;

import me.ztzt.bedwarsupgradesdisplay.bwupgradesdisplay;
import me.ztzt.bedwarsupgradesdisplay.gui.buttons.ToggleButton;
import me.ztzt.bedwarsupgradesdisplay.gui.buttons.UrlButton;
import me.ztzt.bedwarsupgradesdisplay.utils.RoundedUtils;
import me.ztzt.bedwarsupgradesdisplay.utils.UrlUtils;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

import java.awt.*;
import java.io.IOException;

public class BedwarsUpgradesDisplayMenu extends GuiScreen {
    private GuiScreen parentScreen;

    public BedwarsUpgradesDisplayMenu(GuiScreen parentScreen) {
        this.parentScreen = parentScreen;
    }

    @Override
    public void initGui() {
        this.buttonList.add(new ToggleButton(223, width / 2 - 185, height / 2 - 80, 370, 18, "Enable mod"));
        this.buttonList.add(new ToggleButton(224, width / 2 - 185, height / 2 - 62, 370, 18, "Show titles"));

        this.buttonList.add(new UrlButton(225, width / 2 + 87, height / 2 + 83, 33, 11, "Github"));
        super.initGui();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        RoundedUtils.drawRound(width / 2 - 190, height / 2 - 100, 380, 200, 6, new Color(12,12,12));
        mc.fontRendererObj.drawString(bwupgradesdisplay.MODID, width / 2 - (mc.fontRendererObj.getStringWidth(bwupgradesdisplay.MODID) / 2), height / 2 - 94, new Color(222,222,222).getRGB());
        mc.fontRendererObj.drawString("Made with <3 by ztzt. View this project on ", width / 2 - (mc.fontRendererObj.getStringWidth("Made with <3 by ztzt. View this project on Github ") / 2), height / 2 + 85, new Color(105,105,105).getRGB());
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        super.actionPerformed(button);
        switch(button.id) {
            case 223: {
                bwupgradesdisplay.displayEnabled = !bwupgradesdisplay.displayEnabled;
                break;
            }
            case 224: {
                bwupgradesdisplay.showTitles = !bwupgradesdisplay.showTitles;
                break;
            }
            case 225: {
                UrlUtils.openUrl("https://github.com/ztztmc/BedwarsUpgradesDisplay");
            }
        }
        super.actionPerformed(button);
    }
}
