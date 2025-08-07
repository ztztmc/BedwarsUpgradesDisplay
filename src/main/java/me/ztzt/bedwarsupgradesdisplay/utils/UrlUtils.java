package me.ztzt.bedwarsupgradesdisplay.utils;

import org.lwjgl.LWJGLException;
import java.io.IOException;
import org.lwjgl.input.Keyboard;
import net.minecraft.util.Util;

public class UrlUtils
{
    public static void openUrl(final String url) {
        try {
            if (Util.getOSType() == Util.EnumOS.WINDOWS) {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
            }
            else if (Util.getOSType() == Util.EnumOS.OSX) {
                Runtime.getRuntime().exec("open " + url);
                Keyboard.destroy();
                Keyboard.create();
            }
            else {
                Runtime.getRuntime().exec("xdg-open " + url);
            }
        }
        catch (final IOException | LWJGLException e) {
            e.printStackTrace();
        }
    }
}
