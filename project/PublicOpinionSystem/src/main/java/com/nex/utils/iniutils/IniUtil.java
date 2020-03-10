package com.nex.utils.iniutils;

import org.ini4j.Ini;
import org.ini4j.Profile;

import java.io.File;
import java.io.IOException;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.utils.iniutils
 * @Description: ini util
 * @author: nero
 * @date: 2020年03月02日 9:05
 * @version: V1.0
 */
public class IniUtil {

    public IniUtil() {
    }

    /**
     * read ini file by a section, a key
     * @param file ini file
     * @param section ini section
     * @param key ini key
     * @return String
     * @throws IOException /
     */
    public static String readIniFile(File file, String section, String key) throws IOException {

        // create a Ini class
        Ini ini = new Ini();
        // load the file.
        ini.load(file);
        // get section ({key: value})
        Profile.Section sect = ini.get(section);
        // get value
        return sect.get(key);

    }

}
