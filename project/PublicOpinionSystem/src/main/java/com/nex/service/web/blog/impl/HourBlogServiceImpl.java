package com.nex.service.web.blog.impl;

import com.nex.dao.blog.HourBlogRepository;
import com.nex.entity.blog.HourBlog;
import com.nex.service.web.blog.HourBlogService;
import com.nex.service.web.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.service.web.blog.impl
 * @Description: Hour Blog Service Impl
 * @author: nero
 * @date: 2020年03月11日 19:14
 * @version: V1.0
 */
@Service("HourBlogService")
public class HourBlogServiceImpl extends BaseServiceImpl<HourBlog, String> implements HourBlogService {

    /** jpaRepository hourBlogRepository */
    private final HourBlogRepository hourBlogRepository;

    /**
     * @Description: constructor
     * @param hourBlogRepository autowired
     */
    @Autowired
    public HourBlogServiceImpl(HourBlogRepository hourBlogRepository) {
        super.setRepository(hourBlogRepository);
        this.hourBlogRepository = hourBlogRepository;
    }

    @Override
    public List<HourBlog> queryByUser(String userId) {
        return this.hourBlogRepository.findByUser(userId);
    }

    @Override
    public List<HourBlog> queryAll() {
        return this.hourBlogRepository.findAll();
    }


}
