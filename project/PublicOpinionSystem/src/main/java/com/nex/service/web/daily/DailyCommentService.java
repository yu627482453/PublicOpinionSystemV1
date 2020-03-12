package com.nex.service.web.daily;

import com.nex.entity.daily.DailyComment;
import com.nex.service.web.BaseService;

import java.util.List;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.service.web.daily
 * @Description: Daily Comment Service
 * @author: nero
 * @date: 2020年03月11日 20:43
 * @version: V1.0
 */
public interface DailyCommentService extends BaseService<DailyComment, String> {

    /**
     * @Description: query all
     * @return list<DailyComment>
     */
    List<DailyComment> queryAll();
}
