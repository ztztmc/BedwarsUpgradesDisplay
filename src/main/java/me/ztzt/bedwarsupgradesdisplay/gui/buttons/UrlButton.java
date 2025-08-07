package me.ztzt.bedwarsupgradesdisplay.gui.buttons;

import me.ztzt.bedwarsupgradesdisplay.utils.MouseUtils;
import me.ztzt.bedwarsupgradesdisplay.utils.RoundedUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;

import java.awt.*;

public class UrlButton extends GuiButton {

    public UrlButton(int buttonId, int x, int y, int width, int height, String buttonText) {
        super(buttonId, x, y, width, height, buttonText);
    }

    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY) {
        if(!visible) {
            return;
        }

        RoundedUtils.drawRound(xPosition, yPosition, width, height, 3, new Color(35,35,35));
        if(MouseUtils.isInside(mouseX, mouseY, xPosition, yPosition, width, height)) {
            RoundedUtils.drawRound(xPosition, yPosition, width, height, 3, new Color(45,45,45));
        }
        mc.fontRendererObj.drawString(displayString, xPosition + 2, yPosition + 2, new Color(190,190,190).getRGB());
    }
}
