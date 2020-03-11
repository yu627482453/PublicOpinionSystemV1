package com.nex.service.web.impl;

import com.nex.dao.SysUserRepository;
import com.nex.entity.SysUser;
import com.nex.service.web.SysUserService;
import com.nex.utils.encryutils.EncryUitls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.service.web.impl
 * @Description: sysUser service impl
 * @author: nero
 * @date: 2020年03月10日 17:22
 * @version: V1.0
 */
@Service("SysUserService")
public class SysUserServiceImpl extends BaseServiceImpl<SysUser, String> implements SysUserService {

    /** jpaRepository sysUserRepository */
    private final SysUserRepository sysUserRepository;

    /**
     * @Description: constructor
     * @param sysUserRepository autowired
     */
    @Autowired
    public SysUserServiceImpl(SysUserRepository sysUserRepository) {
        super.setRepository(sysUserRepository);
        this.sysUserRepository = sysUserRepository;
    }

    /**
     * @Description: check password
     * @param username username -> String
     * @param password password -> String
     * @return boolean
     */
    @Override
    public boolean checkPassword(String username, String password) {
        SysUser vo = this.sysUserRepository.findByUsername(username);
        if (vo == null){
            return false;
        }
        return vo.getPassword().equals(EncryUitls.encry(password));
    }

    /**
     * @Description: login
     * @param username username -> String
     * @param password password -> String
     * @return vo -> SysUser
     */
    @Override
    public SysUser login(String username, String password) {

        if (checkPassword(username, password)) {
            return this.sysUserRepository.findByUsername(username);
        }

        return null;
    }

    /**
     * @Description: register
     * @param username username -> String
     * @param password password -> String
     * @param email email -> String
     * @return vo -> SysUser
     */
    @Override
    public SysUser register(String username, String password, String email) {

        if(this.sysUserRepository.findByUsername(username) == null){
            SysUser vo = new SysUser();
            vo.setUsername(username);
            vo.setPassword(EncryUitls.encry(password));
            vo.setEmail(email);
            super.updateVO(vo);
            return vo;
        }

        return null;
    }
}
