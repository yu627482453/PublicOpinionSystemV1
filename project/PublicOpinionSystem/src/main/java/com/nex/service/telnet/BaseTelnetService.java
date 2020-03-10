package com.nex.service.telnet;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.service.telnet
 * @Description: BaseTelnetService
 * @author: nero
 * @date: 2020年03月04日 9:59
 * @version: V1.0
 */
public abstract interface BaseTelnetService {

    /**
     * @Description: set the info to connect
     * @param username telnet username
     * @param password telnet password
     * @param host telnet host
     * @param port telnet port
     */
    public void set(String username, String password, String host, int port);

    /**
     * @Description: connect
     * @return true: connected; false: can't connect.
     */
    public boolean connect();

    /**
     * @Description: disconnect
     * @return true: succeed; false: failed.
     */
    public boolean disconnnect();

}
