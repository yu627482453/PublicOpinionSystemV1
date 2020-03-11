package com.nex.service.web.impl;

import com.nex.entity.SysUser;
import com.nex.service.web.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserServiceImplTest {

    @Autowired
    private SysUserService sysUserService;

    @Test
    public void checkPassword() {

    }

    @Test
    public void login() {

        SysUser vo = sysUserService.login("admin", "123456");
        System.out.println(vo.toString());
    }

    @Test
    public void register() {

        SysUser vo = sysUserService.register("admin", "123456", "1234@qq.com");
        System.out.println(vo.toString());

    }
}