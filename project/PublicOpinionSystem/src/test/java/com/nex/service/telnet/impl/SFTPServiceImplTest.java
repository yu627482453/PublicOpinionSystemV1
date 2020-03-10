package com.nex.service.telnet.impl;

import com.nex.service.telnet.SFTPService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SFTPServiceImplTest {

    @Autowired
    private SFTPService sftpService;

    @Before
    public void setUp() throws Exception {
        this.sftpService.set("nex", "000000", "hadoop102", 22);
        this.sftpService.connect();
    }

    @After
    public void tearDown() throws Exception {
        this.sftpService.disconnnect();
    }

    @Test
    public void uploadFile() {
        boolean result = this.sftpService.uploadFile("/tmp/logs", "D:\\data\\test\\1.txt");
        System.out.println(result);

    }

    @Test
    public void uploadDirFiles() {
        boolean result = this.sftpService.uploadDirFiles("/tmp/logs", "D:\\gitRepository\\PublicOpinionSystem\\src\\main\\resources\\data\\weibo");
        System.out.println(result);
    }
}