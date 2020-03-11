package com.nex.service.web.blog;

import com.nex.entity.blog.DayBlog;
import com.nex.service.web.BaseService;

import java.util.List;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.service.web
 * @Description: DayBlog Service
 * @author: nero
 * @date: 2020年03月11日 14:24
 * @version: V1.0
 */
public interface DayBlogService extends BaseService<DayBlog, String> {

    /**
     * @Description: query by user id
     * @param userId user id
     * @return list<DayBlog>
     */
    List<DayBlog> queryByUser(String userId);

    /**
     * @Description: query all
     * @return List<DayBlog>
     */
    List<DayBlog> queryAll();
}
