package com.nex.utils;

import com.jcraft.jsch.*;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;
import java.util.Vector;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.utils
 * @Description: util for sftp ( Organized from "https://blog.csdn.net/yhl_jxy/article/details/72633034" )
 * @author: nero
 * @date: 2020年03月01日 20:51
 * @version: V1.0
 */
public class SFTPUtil {

    private transient Logger log = LoggerFactory.getLogger(this.getClass());

    private ChannelSftp sftp;

    private Session session;
    /** SFTP username */
    private String username;
    /** SFTP password */
    private String password;
    /** private key */
    private String privateKey;
    /** SFTP host */
    private String host;
    /** SFTP port */
    private int port;

    /**
     * Constructor with password
     * @param username sftp username
     * @param password sftp password
     * @param host sftp host
     * @param port sftp port
     */
    public SFTPUtil(String username, String password, String host, int port) {
        this.username = username;
        this.password = password;
        this.host = host;
        this.port = port;
    }

    /**
     * Constructor with private key
     * @param username sftp username
     * @param host sftp host
     * @param port sftp port
     * @param privateKey sftp private key
     */
    public SFTPUtil(String username, String host, int port, String privateKey) {
        this.username = username;
        this.host = host;
        this.port = port;
        this.privateKey = privateKey;
    }

    /**
     * Constructor with nothing
     */
    public SFTPUtil() {
    }

    /**
     * login to connect sftp
     * @return true: succeed; false: failed.
     */
    public boolean login() {
        try {
            JSch jsch = new JSch();
            if (privateKey != null) {

                // connect with private key
                jsch.addIdentity(privateKey);
                log.info("sftp connect,path of private key file：{}" , privateKey);
            }
            log.info("sftp connect by host:{} username:{}",host,username);
            session = jsch.getSession(username, host, port);
            if (password != null) {
                session.setPassword(password);
            }
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");

            session.setConfig(config);
            session.connect();
            log.info("Session is connected");

            Channel channel = session.openChannel("sftp");
            channel.connect();
            log.info("channel is connected");

            sftp = (ChannelSftp) channel;
            log.info(String.format("sftp server host:[%s] port:[%s] is connect successfull", host, port));

            return true;

        } catch (JSchException e) {
            e.printStackTrace();
            log.error("Cannot connect to specified sftp server : {}:{} \n Exception message is: {}", host, port, e.getMessage());
            return false;
        }
    }

    /**
     * logout after used
     */
    public void logout() {
        if (sftp != null) {
            if (sftp.isConnected()) {
                sftp.disconnect();
                log.info("sftp is closed already");
            }
        }
        if (session != null) {
            if (session.isConnected()) {
                session.disconnect();
                log.info("sshSession is closed already");
            }
        }
    }

    /**
     * upload inputStream to sftp
     * @param directory remote directory to upload
     * @param sftpFileName remote file to upload
     * @param input inputStream to upload
     * @throws SftpException
     */
    public void upload(String directory, String sftpFileName, InputStream input) throws SftpException{
        try {
            sftp.cd(directory);
        } catch (SftpException e) {
            log.warn("directory is not exist");
            sftp.mkdir(directory);
            sftp.cd(directory);
        }
        sftp.put(input, sftpFileName);
        log.info("file:{} is upload successful" , sftpFileName);
    }

    /**
     * upload a file to sftp
     * @param directory remote directory to upload
     * @param uploadFile sftp file to upload
     * @throws FileNotFoundException
     * @throws SftpException
     */
    public void upload(String directory, String uploadFile) throws FileNotFoundException, SftpException{
        File file = new File(uploadFile);
        upload(directory, file.getName(), new FileInputStream(file));
    }

    /**
     * upload byte[] to sftp
     * @param directory remote directory to upload
     * @param sftpFileName remote file to upload
     * @param byteArr data of byteArray to upload
     * @throws SftpException
     */
    public void upload(String directory, String sftpFileName, byte[] byteArr) throws SftpException{
        upload(directory, sftpFileName, new ByteArrayInputStream(byteArr));
    }

    /**
     * upload String to sftp
     * @param directory remote directory to upload
     * @param sftpFileName remote file to upload
     * @param dataStr data of String to upload
     * @param charsetName charset
     * @throws UnsupportedEncodingException
     * @throws SftpException
     */
    public void upload(String directory, String sftpFileName, String dataStr, String charsetName) throws UnsupportedEncodingException, SftpException{
        upload(directory, sftpFileName, new ByteArrayInputStream(dataStr.getBytes(charsetName)));
    }

    /**
     * download to save as a file
     * @param directory remote directory to download
     * @param downloadFile remote file to download
     * @param saveFile local file to save
     * @throws SftpException
     * @throws FileNotFoundException
     */
    public void download(String directory, String downloadFile, String saveFile) throws SftpException, FileNotFoundException{
        if (directory != null && !"".equals(directory)) {
            sftp.cd(directory);
        }
        File file = new File(saveFile);
        sftp.get(downloadFile, new FileOutputStream(file));
        log.info("file:{} is download successful" , downloadFile);
    }
    /**
     * download to save as byte[]
     * @param directory remote directory to download
     * @param downloadFile remote file to download
     * @return byte[]
     * @throws SftpException
     * @throws IOException
     * @throws Exception
     */
    public byte[] download(String directory, String downloadFile) throws SftpException, IOException{
        if (directory != null && !"".equals(directory)) {
            sftp.cd(directory);
        }
        InputStream is = sftp.get(downloadFile);

        byte[] fileData = IOUtils.toByteArray(is);

        log.info("file:{} is download successful" , downloadFile);
        return fileData;
    }

    /**
     *
     * @param directory remote directory to delete
     * @param deleteFile remote file to delete
     * @throws SftpException
     */
    public void delete(String directory, String deleteFile) throws SftpException{
        sftp.cd(directory);
        sftp.rm(deleteFile);
    }

    /**
     * listFiles like "ls"
     * @param directory remote directory to show
     * @return Vector
     * @throws SftpException
     */
    public Vector<?> listFiles(String directory) throws SftpException {
        return sftp.ls(directory);
    }

}
