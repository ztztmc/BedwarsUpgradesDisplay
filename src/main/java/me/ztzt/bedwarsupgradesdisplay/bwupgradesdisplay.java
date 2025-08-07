package me.ztzt.bedwarsupgradesdisplay;

import me.ztzt.bedwarsupgradesdisplay.gui.handlers.PauseMenuHandler;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = bwupgradesdisplay.MODID, version = bwupgradesdisplay.VERSION)
public class bwupgradesdisplay {
    public static final String MODID = "Bedwars Upgrades Display";
    public static final String VERSION = "1.0";
    public static boolean displayEnabled;
    public static boolean showTitles;

    @Mod.EventHandler
    public void preInit(final FMLPreInitializationEvent event) {
        ConfigManager.loadConfig();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println("[ztzt mods/" + MODID + "] Initialized.");
        MinecraftForge.EVENT_BUS.register((Object)new ChatListener());
        MinecraftForge.EVENT_BUS.register((Object)new HUDRenderer());
        new PauseMenuHandler();
    }
}
