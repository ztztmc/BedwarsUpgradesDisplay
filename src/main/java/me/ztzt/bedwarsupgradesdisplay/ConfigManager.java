package me.ztzt.bedwarsupgradesdisplay;

import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.FileReader;
import java.io.File;
import com.google.gson.Gson;

public class ConfigManager
{
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final File CONFIG_FILE = new File("ztzt mods/bwupgradesdisplay.json");
    public static Config config = new Config();

    public static void loadConfig() {
        if (ConfigManager.CONFIG_FILE.exists()) {
            try (final FileReader reader = new FileReader(ConfigManager.CONFIG_FILE)) {
                ConfigManager.config = (Config)ConfigManager.GSON.fromJson((Reader)reader, (Class)Config.class);
                bwupgradesdisplay.displayEnabled = ConfigManager.config.displayEnabled;
                bwupgradesdisplay.showTitles = ConfigManager.config.showTitles;
            }
            catch (final IOException e) {
                e.printStackTrace();
            }
        }
        else {
            saveConfig();
        }
    }

    public static void saveConfig() {
        try {
            if (!ConfigManager.CONFIG_FILE.getParentFile().exists()) {
                ConfigManager.CONFIG_FILE.getParentFile().mkdirs();
            }
            try (final FileWriter writer = new FileWriter(ConfigManager.CONFIG_FILE)) {
                ConfigManager.GSON.toJson((Object)ConfigManager.config, (Appendable)writer);
            }
        }
        catch (final IOException e) {
            e.printStackTrace();
        }
    }

    public static class Config
    {
        public boolean displayEnabled;
        public boolean showTitles;

        public Config() {
            this.displayEnabled = true;
            this.showTitles = true;
        }
    }
}
