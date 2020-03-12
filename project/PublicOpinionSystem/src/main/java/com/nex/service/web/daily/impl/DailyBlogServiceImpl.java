package com.nex.service.web.daily.impl;

import com.nex.dao.daily.DailyBlogRepository;
import com.nex.entity.daily.DailyBlog;
import com.nex.service.web.daily.DailyBlogService;
import com.nex.service.web.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.service.web.daily.impl
 * @Description: DailyBlog Service impl
 * @author: nero
 * @date: 2020年03月11日 19:55
 * @version: V1.0
 */
@Service("DailyBlogService")
public class DailyBlogServiceImpl extends BaseServiceImpl<DailyBlog, String> implements DailyBlogService {

    /** jpaRepository dailyBlogRepository */
    private final DailyBlogRepository dailyBlogRepository;

    /**
     * @Description: constructor
     * @param dailyBlogRepository autowired
     */
    @Autowired
    public DailyBlogServiceImpl(DailyBlogRepository dailyBlogRepository) {
        super.setRepository(dailyBlogRepository);
        this.dailyBlogRepository = dailyBlogRepository;
    }

    @Override
    public List<DailyBlog> queryAll() {
        return dailyBlogRepository.findAll();
    }
}
