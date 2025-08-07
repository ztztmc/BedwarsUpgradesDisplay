package me.ztzt.bedwarsupgradesdisplay.gui.handlers;

import me.ztzt.bedwarsupgradesdisplay.gui.BedwarsUpgradesDisplayMenu;
import me.ztzt.bedwarsupgradesdisplay.gui.buttons.PauseMenuButton;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PauseMenuHandler {
    public PauseMenuHandler() {
        MinecraftForge.EVENT_BUS.register((Object)this);
    }

    @SubscribeEvent
    public void onPauseMenuInit(GuiScreenEvent.InitGuiEvent.Post event) {
        GuiScreen gui = event.gui;
        if (gui instanceof GuiIngameMenu) {
            event.buttonList.add(new PauseMenuButton(222, gui.width - 100, gui.height - 25, 93, 18, "Upgrades Display"));
        }
    }

    @SubscribeEvent
    public void onButtonPress(GuiScreenEvent.ActionPerformedEvent.Post event) {
        GuiScreen gui = event.gui;
        GuiButton button = event.button;
        if (gui instanceof GuiIngameMenu && button.id == 222) {
            gui.mc.displayGuiScreen((GuiScreen)new BedwarsUpgradesDisplayMenu(gui));
        }
    }
}
