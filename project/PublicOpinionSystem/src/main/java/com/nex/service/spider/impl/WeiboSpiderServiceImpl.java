package com.nex.service.spider.impl;

import com.nex.service.spider.WeiboSpiderService;
import org.springframework.stereotype.Service;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.service.spider.impl
 * @Description: spider to crawl weibo.
 * @author: nero
 * @date: 2020年03月02日 16:30
 * @version: V1.0
 */
@Service("WeiboSpiderService")
public class WeiboSpiderServiceImpl extends BaseSpiderServiceImpl implements WeiboSpiderService {

    @Override
    public boolean setSpider() {
        super.setSectionName("weiboSpider");
        return super.setSpider();
    }
}
