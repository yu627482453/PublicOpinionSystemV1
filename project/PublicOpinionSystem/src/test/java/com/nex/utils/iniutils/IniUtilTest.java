package com.nex.utils.iniutils;

import com.nex.constant.GlobalConstant;
import org.junit.Test;

import java.io.File;
import java.io.IOException;


public class IniUtilTest {

    @Test
    public void readIniFile() throws IOException {
        File file = new File(GlobalConstant.MY_INI_PATH);
        System.out.println(GlobalConstant.MY_INI_PATH);
        System.out.println(file.exists());
        if (file.exists()) {
            String value = IniUtil.readIniFile(file, "weiboSpider", "index_dir");

            System.out.println(value);
        }

    }
}