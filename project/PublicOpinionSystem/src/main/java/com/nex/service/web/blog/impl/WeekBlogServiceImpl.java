package com.nex.service.web.blog.impl;

import com.nex.dao.blog.WeekBlogRepository;
import com.nex.entity.blog.WeekBlog;
import com.nex.service.web.blog.WeekBlogService;
import com.nex.service.web.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.service.web.blog.impl
 * @Description: Week Blog Service impl
 * @author: nero
 * @date: 2020年03月11日 19:15
 * @version: V1.0
 */
@Service("WeekBlogService")
public class WeekBlogServiceImpl extends BaseServiceImpl<WeekBlog, String> implements WeekBlogService {

    /** jpaRepository weekBlogRepository */
    private final WeekBlogRepository weekBlogRepository;

    /**
     * @Description: constructor
     * @param weekBlogRepository autowired
     */
    @Autowired
    public WeekBlogServiceImpl(WeekBlogRepository weekBlogRepository) {
        super.setRepository(weekBlogRepository);
        this.weekBlogRepository = weekBlogRepository;
    }

    @Override
    public List<WeekBlog> queryByUser(String userId) {
        return this.weekBlogRepository.findByUser(userId);
    }

    @Override
    public List<WeekBlog> queryAll() {
        return this.weekBlogRepository.findAll();
    }


}
