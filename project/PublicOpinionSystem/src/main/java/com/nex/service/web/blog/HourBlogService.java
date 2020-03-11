package com.nex.service.web.blog;

import com.nex.entity.blog.HourBlog;
import com.nex.service.web.BaseService;

import java.util.List;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.service.web.blog
 * @Description: Hour Blog Service
 * @author: nero
 * @date: 2020年03月11日 18:05
 * @version: V1.0
 */
public interface HourBlogService extends BaseService<HourBlog, String> {

    /**
     * @Description: query by user id
     * @param userId user id
     * @return list<HourBlog>
     */
    List<HourBlog> queryByUser(String userId);

    /**
     * @Description: query all
     * @return List<HourBlog>
     */
    List<HourBlog> queryAll();

}
