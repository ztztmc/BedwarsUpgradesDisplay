package me.ztzt.bedwarsupgradesdisplay.utils;

import java.io.IOException;
import java.io.File;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

public class FileUtils
{
    public static String readInputStream(final InputStream inputStream) {
        final StringBuilder stringBuilder = new StringBuilder();
        try {
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append('\n');
            }
        }
        catch (final Exception e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static void createDir(final File file) {
        if (!file.exists()) {
            file.mkdir();
        }
    }

    public static void createFile(final File file) {
        if (!file.exists()) {
            try {
                file.createNewFile();
            }
            catch (final IOException e) {
                e.printStackTrace();
            }
        }
    }
}
