package com.nex.utils;

import com.jcraft.jsch.SftpException;
import com.nex.utils.iniutils.MyIniUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class SFTPUtilTest {

    private SFTPUtil sftp;

    @Before
    public void setUp() throws Exception {
        System.out.println("*****START******");
        sftp = new SFTPUtil("atguigu", "000000", "hadoop102", 22);
        sftp.login();
    }

    @After
    public void tearDown() throws Exception {
        sftp.logout();
        System.out.println("******END******");
    }

    @Test
    public void login() {
    }

    @Test
    public void logout() {
    }

    @Test
    public void upload() throws IOException, SftpException {
        sftp.upload("/opt/software", MyIniUtil.readMyIniFile("Spider", "comment_dir") + "/1.txt");
    }

    @Test
    public void testUpload() {
    }

    @Test
    public void testUpload1() {
    }

    @Test
    public void testUpload2() {
    }

    @Test
    public void download() {
    }

    @Test
    public void testDownload() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void listFiles() {
    }
}