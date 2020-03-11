package com.nex.service.web.blog.impl;

import com.nex.dao.blog.LastDayBlogRepository;
import com.nex.entity.blog.LastDayBlog;
import com.nex.service.web.blog.LastDayBlogService;
import com.nex.service.web.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.service.web.blog.impl
 * @Description: Last Day Blog ServiceImpl
 * @author: nero
 * @date: 2020年03月11日 19:15
 * @version: V1.0
 */
@Service("LastDayBlogService")
public class LastDayBlogServiceImpl extends BaseServiceImpl<LastDayBlog, String> implements LastDayBlogService {

    /** jpaRepository lastDayBlogRepository */
    private final LastDayBlogRepository lastDayBlogRepository;

    /**
     * @Description: constructor
     * @param lastDayBlogRepository autowired
     */
    @Autowired
    public LastDayBlogServiceImpl(LastDayBlogRepository lastDayBlogRepository) {
        super.setRepository(lastDayBlogRepository);
        this.lastDayBlogRepository = lastDayBlogRepository;
    }

    @Override
    public List<LastDayBlog> queryByUser(String userId) {
        return this.lastDayBlogRepository.findByUser(userId);
    }

    @Override
    public List<LastDayBlog> queryAll() {
        return this.lastDayBlogRepository.findAll();
    }


}
