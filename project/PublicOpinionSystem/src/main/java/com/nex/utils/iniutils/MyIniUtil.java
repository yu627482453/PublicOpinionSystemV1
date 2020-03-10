package com.nex.utils.iniutils;

import com.nex.constant.GlobalConstant;

import java.io.File;
import java.io.IOException;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.utils.iniutils
 * @Description: TODO
 * @author: nero
 * @date: 2020年03月02日 10:08
 * @version: V1.0
 */
public class MyIniUtil {

    /**
     * get key in my.ini
     * @param section section
     * @param key key
     * @return String value
     * @throws IOException /
     */
    public static String readMyIniFile(String section, String key) throws IOException {

        return IniUtil.readIniFile(new File(GlobalConstant.MY_INI_PATH), section, key);

    }

}
