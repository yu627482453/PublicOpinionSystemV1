package com.nex.service.telnet.impl;

import com.nex.service.telnet.BaseTelnetService;
import lombok.Data;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.service.telnet.impl
 * @Description: TODO
 * @author: nero
 * @date: 2020年03月04日 10:10
 * @version: V1.0
 */
@Data
public abstract class BaseTelnetServiceImpl implements BaseTelnetService {

    private String username;
    private String password;
    private String host;
    private int port;

    @Override
    public void set(String username, String password, String host, int port) {
        this.username = username;
        this.password = password;
        this.host = host;
        this.port = port;
    }

}
