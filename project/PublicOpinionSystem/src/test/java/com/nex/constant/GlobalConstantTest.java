package com.nex.constant;

import org.junit.Test;


public class GlobalConstantTest {

    @Test
    public void getProjectRoot() {
        System.out.println("PROJECT_ROOT:");
        System.out.println(GlobalConstant.PROJECT_ROOT);
    }

    @Test
    public void getConfigPath() {
        System.out.println("CONFIG_PATH:");
        System.out.println(GlobalConstant.CONFIG_PATH);
    }

    @Test
    public void getMyIniPath() {
        System.out.println("MY_INI_PATH:");
        System.out.println(GlobalConstant.MY_INI_PATH);
    }

}