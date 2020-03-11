package com.nex.service.web.blog.impl;

import com.nex.dao.blog.YesDayBlogRepository;
import com.nex.entity.blog.YesDayBlog;
import com.nex.service.web.blog.YesDayBlogService;
import com.nex.service.web.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.service.web.blog.impl
 * @Description: Yes Day Blog Service Impl
 * @author: nero
 * @date: 2020年03月11日 19:15
 * @version: V1.0
 */
@Service("YesDayBlogService")
public class YesDayBlogServiceImpl extends BaseServiceImpl<YesDayBlog, String> implements YesDayBlogService {

    /** jpaRepository yesDayBlogRepository */
    private final YesDayBlogRepository yesDayBlogRepository;

    /**
     * @Description: constructor
     * @param yesDayBlogRepository autowired
     */
    @Autowired
    public YesDayBlogServiceImpl(YesDayBlogRepository yesDayBlogRepository) {
        super.setRepository(yesDayBlogRepository);
        this.yesDayBlogRepository = yesDayBlogRepository;
    }

    @Override
    public List<YesDayBlog> queryByUser(String userId) {
        return this.yesDayBlogRepository.findByUser(userId);
    }

    @Override
    public List<YesDayBlog> queryAll() {
        return this.yesDayBlogRepository.findAll();
    }


}
