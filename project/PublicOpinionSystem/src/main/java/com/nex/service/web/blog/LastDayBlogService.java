package com.nex.service.web.blog;

import com.nex.entity.blog.LastDayBlog;
import com.nex.service.web.BaseService;

import java.util.List;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.service.web.blog
 * @Description: Last Day Blog Service
 * @author: nero
 * @date: 2020年03月11日 18:03
 * @version: V1.0
 */
public interface LastDayBlogService extends BaseService<LastDayBlog, String> {

    /**
     * @Description: query by user id
     * @param userId user id
     * @return list<LastDayBlog>
     */
    List<LastDayBlog> queryByUser(String userId);

    /**
     * @Description: query all
     * @return List<LastDayBlog>
     */
    List<LastDayBlog> queryAll();
}
