package com.nex.service.web.blog.impl;

import com.nex.dao.blog.DayBlogRepository;
import com.nex.entity.blog.DayBlog;
import com.nex.service.web.blog.DayBlogService;
import com.nex.service.web.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.service.web.blog.impl
 * @Description: DayBlog Service Impl
 * @author: nero
 * @date: 2020年03月11日 14:30
 * @version: V1.0
 */
@Service("DayBlogService")
public class DayBlogServiceImpl extends BaseServiceImpl<DayBlog, String> implements DayBlogService {

    /** jpaRepository dayBlogRepository */
    private final DayBlogRepository dayBlogRepository;

    /**
     * @Description: constructor
     * @param dayBlogRepository autowired
     */
    @Autowired
    public DayBlogServiceImpl(DayBlogRepository dayBlogRepository) {
        super.setRepository(dayBlogRepository);
        this.dayBlogRepository = dayBlogRepository;
    }

    @Override
    public List<DayBlog> queryByUser(String userId) {
        return this.dayBlogRepository.findByUser(userId);
    }

    @Override
    public List<DayBlog> queryAll() {
        return this.dayBlogRepository.findAll();
    }

}
