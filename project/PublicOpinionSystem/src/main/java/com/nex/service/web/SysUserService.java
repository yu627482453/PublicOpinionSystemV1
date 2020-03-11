package com.nex.service.web;

import com.nex.entity.SysUser;
import org.springframework.stereotype.Service;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.service.web
 * @Description: SysUser Service
 * @author: nero
 * @date: 2020年03月10日 14:36
 * @version: V1.0
 */
public interface SysUserService extends BaseService<SysUser, String> {

    /**
     * @Description: check password
     * @param username username -> String
     * @param password password -> String
     * @return boolean
     */
    boolean checkPassword(String username, String password);

    /**
     * @Description: login
     * @param username username -> String
     * @param password password -> String
     * @return SysUser
     */
    SysUser login(String username, String password);

    /**
     * @Description: regist
     * @param username username -> String
     * @param password password -> String
     * @param email email -> String
     * @return SysUser
     */
    SysUser register(String username, String password, String email);

}
