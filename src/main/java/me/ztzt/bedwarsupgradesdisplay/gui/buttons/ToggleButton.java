package me.ztzt.bedwarsupgradesdisplay.gui.buttons;

import me.ztzt.bedwarsupgradesdisplay.bwupgradesdisplay;
import me.ztzt.bedwarsupgradesdisplay.utils.RoundedUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;

import java.awt.*;

public class ToggleButton extends GuiButton {

    public ToggleButton(int buttonId, int x, int y, int width, int height, String buttonText) {
        super(buttonId, x, y, width, height, buttonText);
    }

    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY) {
        if(!visible) {
            return;
        }
        mc.fontRendererObj.drawString(displayString, xPosition + 5, yPosition + 5, new Color(205,205,205).getRGB());

        if(displayString == "Enable mod")
            RoundedUtils.drawRound(xPosition + 50, yPosition + height - 1, width - 100, 0.5f, 0, new Color(35,35,35));

        if(displayString == "Enable mod" && bwupgradesdisplay.displayEnabled || displayString == "Show titles" && bwupgradesdisplay.showTitles) {
            RoundedUtils.drawRound(xPosition + width - 25, yPosition + 4, 18, 10, 5, new Color(155,155,155));
            RoundedUtils.drawRound(xPosition + width - 15, yPosition + 6, 6, 6, 3, new Color(1,1,1));
        } else {
            RoundedUtils.drawRound(xPosition + width - 25, yPosition + 4, 18, 10, 5, new Color(100,100,100));
            RoundedUtils.drawRound(xPosition + width - 23, yPosition + 6, 6, 6, 3, new Color(1,1,1));
        }
    }
}
