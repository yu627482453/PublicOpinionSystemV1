package com.nex.service.spider.impl;

import com.nex.service.spider.WeiboSpiderService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeiboSpiderServiceImplTest {

    @Autowired
    private WeiboSpiderService weiboSpiderService;

    @Before
    public void setUp() throws Exception {
        weiboSpiderService.setSpider();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void crawlIndex() {
        weiboSpiderService.crawlIndex();
    }

    @Test
    public void crawlComment() {
        weiboSpiderService.crawlComment("4478515040594015");
    }
}