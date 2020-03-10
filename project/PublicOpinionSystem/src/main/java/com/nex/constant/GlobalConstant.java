package com.nex.constant;

import java.io.File;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.constant
 * @Description: TODO
 * @author: nero
 * @date: 2020年03月02日 9:38
 * @version: V1.0
 */
public final class GlobalConstant {

    private GlobalConstant() {
    }

    /** project root path */
    public static final String PROJECT_ROOT = System.getProperty("user.dir");


    //TODO TEST_CONFIG_PATH
    // PROJECT_ROOT + "\\resource\\config";
    /** config path */
    public static final String CONFIG_PATH = "D:\\gitRepository\\PublicOpinionSystem\\src\\main\\resources\\config";

    /** my.ini path */
    public static final String MY_INI_PATH = CONFIG_PATH +  "\\my.ini";

}
