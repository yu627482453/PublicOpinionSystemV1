package com.nex.service.web.daily;

import com.nex.entity.daily.DailyBlog;
import com.nex.service.web.BaseService;

import java.util.List;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.service.web.daily
 * @Description: DailyBlog Service
 * @author: nero
 * @date: 2020年03月11日 19:52
 * @version: V1.0
 */
public interface DailyBlogService extends BaseService<DailyBlog, String> {


    /**
     * @Description: query all
     * @return List<DailyBlog>
     */
    List<DailyBlog> queryAll();

}
