package com.nex.service.web.blog;

import com.nex.entity.blog.WeekBlog;
import com.nex.service.web.BaseService;

import java.util.List;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.service.web.blog
 * @Description: Week Blog Service
 * @author: nero
 * @date: 2020年03月11日 18:04
 * @version: V1.0
 */
public interface WeekBlogService extends BaseService<WeekBlog, String> {

    /**
     * @Description: query by user id
     * @param userId user id
     * @return list<WeekBlog>
     */
    List<WeekBlog> queryByUser(String userId);

    /**
     * @Description: query all
     * @return List<WeekBlog>
     */
    List<WeekBlog> queryAll();
}
