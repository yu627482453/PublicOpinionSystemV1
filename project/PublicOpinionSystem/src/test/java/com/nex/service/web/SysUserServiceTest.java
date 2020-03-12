package com.nex.service.web;

import com.nex.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserServiceTest {

    @Autowired
    private SysUserService sysUserService;

    @Test
    public void test() {
        System.out.println(sysUserService.queryVO("4028818170c3fd860170c3fd93120000").toString());

    }

}