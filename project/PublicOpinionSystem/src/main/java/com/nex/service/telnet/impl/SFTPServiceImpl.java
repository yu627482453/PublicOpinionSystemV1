package com.nex.service.telnet.impl;

import com.jcraft.jsch.SftpException;
import com.nex.service.telnet.BaseTelnetService;
import com.nex.service.telnet.SFTPService;
import com.nex.utils.SFTPUtil;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.service.telnet.impl
 * @Description: SFTP Service impl.
 * @author: nero
 * @date: 2020年03月04日 10:14
 * @version: V1.0
 */
@Service("SFTPService")
public class SFTPServiceImpl extends BaseTelnetServiceImpl implements SFTPService {

    /** util for sftp */
    private SFTPUtil sftpUtil;

    /**
     * @Description: set the sftpUtil
     * @param username telnet username
     * @param password telnet password
     * @param host telnet host
     * @param port telnet port
     */
    @Override
    public void set(String username, String password, String host, int port) {
        super.set(username, password, host, port);
        sftpUtil = new SFTPUtil(username, password, host, port);
    }

    /**
     * @Description: connect
     * @return true: succeed; false: failed.
     */
    @Override
    public boolean connect() {
        if (sftpUtil != null) {
            return sftpUtil.login();
        }
        return false;
    }

    /**
     * @Description: disconnect
     * @return true: succeed; false: failed.
     */
    @Override
    public boolean disconnnect() {
        if (sftpUtil != null) {
            sftpUtil.logout();
            return true;
        }

        return false;
    }

    /**
     * @Description: upload local File to remote host.
     * @param remoteDirectory remote Directory.
     * @param uploadFile local file to upload.
     * @return ture: succeed; false: failed.
     */
    @Override
    public boolean uploadFile(String remoteDirectory, String uploadFile) {
        try {
            sftpUtil.upload(remoteDirectory, uploadFile);
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SftpException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * @Description: upload local Directory to remote host.
     * @param remoteDirectory remote Directory.
     * @param localDirectory local Directory.
     * @return true: succeed; false: failed.
     */
    @Override
    public boolean uploadDirFiles(String remoteDirectory, String localDirectory) {

        File localDir = new File(localDirectory);

        if (localDir.isDirectory()) {
            String[] fileList = localDir.list();

            for (String file : fileList) {

                String filePath = localDirectory + "//" + file;

                if (!new File(filePath).isDirectory()) {
                    try {
                        sftpUtil.upload(remoteDirectory, filePath);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (SftpException e) {
                        e.printStackTrace();
                    }
                }

            }

            return true;
        }

        return false;
    }

}
