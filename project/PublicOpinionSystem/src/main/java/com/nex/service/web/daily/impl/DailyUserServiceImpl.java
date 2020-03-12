package com.nex.service.web.daily.impl;

import com.nex.dao.daily.DailyUserRepository;
import com.nex.entity.daily.DailyUser;
import com.nex.service.web.daily.DailyUserService;
import com.nex.service.web.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.service.web.daily.impl
 * @Description: Daily User Service impl
 * @author: nero
 * @date: 2020年03月11日 20:47
 * @version: V1.0
 */
@Service("DailyUserService")
public class DailyUserServiceImpl extends BaseServiceImpl<DailyUser, String> implements DailyUserService {

    /** jpaRepository dailyUserRepository */
    private final DailyUserRepository dailyUserRepository;

    /**
     * @Description: constructor
     * @param dailyUserRepository autowired
     */
    @Autowired
    public DailyUserServiceImpl(DailyUserRepository dailyUserRepository) {
        super.setRepository(dailyUserRepository);
        this.dailyUserRepository = dailyUserRepository;
    }

    @Override
    public List<DailyUser> queryAll() {
        return dailyUserRepository.findAll();
    }
}
