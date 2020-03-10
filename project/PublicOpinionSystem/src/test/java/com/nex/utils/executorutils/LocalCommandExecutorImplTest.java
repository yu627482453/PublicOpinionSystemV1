package com.nex.utils.executorutils;

import com.nex.utils.iniutils.MyIniUtil;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class LocalCommandExecutorImplTest {

    @Test
    public void executeCommand() throws IOException {
        LocalCommandExecutorImpl localCommandExecutor = new LocalCommandExecutorImpl();

        String project_dir = MyIniUtil.readMyIniFile("weiboSpider", "project_dir");

        String name = MyIniUtil.readMyIniFile("weiboSpider", "name");

        ExecuteResult executeResult = localCommandExecutor.executeCommand("cmd.exe /c cd "+ project_dir + " && scrapy crawl " + name, 20000);
        System.out.println(executeResult.toString());
    }
}