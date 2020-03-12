package com.nex.service.web.daily;

import com.nex.entity.daily.DailyUser;
import com.nex.service.web.BaseService;

import java.util.List;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.service.web.daily
 * @Description: TODO
 * @author: nero
 * @date: 2020年03月11日 20:43
 * @version: V1.0
 */
public interface DailyUserService extends BaseService<DailyUser, String> {

    /**
     * @Description: query all
     * @return List<DailyUser>
     */
    List<DailyUser> queryAll();
}
