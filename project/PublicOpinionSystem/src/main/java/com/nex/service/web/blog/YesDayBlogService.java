package com.nex.service.web.blog;

import com.nex.entity.blog.YesDayBlog;
import com.nex.service.web.BaseService;

import java.util.List;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.service.web.blog
 * @Description: Yes Day Blog Service
 * @author: nero
 * @date: 2020年03月11日 18:03
 * @version: V1.0
 */
public interface YesDayBlogService extends BaseService<YesDayBlog, String> {
    /**
     * @Description: query by user id
     * @param userId user id
     * @return list<YesDayBlog>
     */
    List<YesDayBlog> queryByUser(String userId);

    /**
     * @Description: query all
     * @return List<YesDayBlog>
     */
    List<YesDayBlog> queryAll();
}
