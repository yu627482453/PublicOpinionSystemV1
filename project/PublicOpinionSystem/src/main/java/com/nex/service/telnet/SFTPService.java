package com.nex.service.telnet;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.service.telnet
 * @Description: SFTP Service.
 * @author: nero
 * @date: 2020年03月04日 9:58
 * @version: V1.0
 */
public interface SFTPService extends BaseTelnetService {

    /**
     * @Description: upload local file to remote Directory.
     * @param remoteDirectory remote Directory.
     * @param uploadFile local file to upload.
     */
    public boolean uploadFile(String remoteDirectory, String uploadFile);

    /**
     * @Description: upload local files in localDirectory to remote Directory.
     * @param remoteDirectory remote Directory.
     * @param localDirectory local Directory.
     */
    public boolean uploadDirFiles(String remoteDirectory, String localDirectory);
}
