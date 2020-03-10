package com.nex.utils.iniutils;

import org.junit.Test;

import java.io.IOException;

public class MyIniUtilTest {

    @Test
    public void readMyIniFile() throws IOException {
        String s = MyIniUtil.readMyIniFile("weiboSpider", "1");
        System.out.println(s);
    }
}