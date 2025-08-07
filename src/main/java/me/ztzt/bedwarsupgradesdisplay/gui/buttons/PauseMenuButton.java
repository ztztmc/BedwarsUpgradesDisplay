package me.ztzt.bedwarsupgradesdisplay.gui.buttons;

import java.awt.Color;

import me.ztzt.bedwarsupgradesdisplay.utils.MouseUtils;
import me.ztzt.bedwarsupgradesdisplay.utils.RoundedUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;

public class PauseMenuButton extends GuiButton
{
    public PauseMenuButton(int buttonId, int x, int y, int width, int height, String buttonText) {
        super(buttonId, x, y, width, height, buttonText);
    }

    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY) {
        if(!visible) {
            return;
        }
        RoundedUtils.drawRound(xPosition, yPosition, width, height, 4, new Color(12, 12, 12));
        if (MouseUtils.isInside(mouseX, mouseY, xPosition, yPosition, width, height)) {
            RoundedUtils.drawRound(xPosition, yPosition, width, height, 4, new Color(18, 18, 18));
        }
        mc.fontRendererObj.drawString(displayString, xPosition + 4, yPosition + 5, new Color(222, 222, 222).getRGB());
    }
}
