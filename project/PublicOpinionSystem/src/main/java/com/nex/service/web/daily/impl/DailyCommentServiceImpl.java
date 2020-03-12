package com.nex.service.web.daily.impl;

import com.nex.dao.daily.DailyCommentRepository;
import com.nex.entity.daily.DailyComment;
import com.nex.service.web.daily.DailyCommentService;
import com.nex.service.web.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.service.web.daily.impl
 * @Description: Daily Comment Service impl
 * @author: nero
 * @date: 2020年03月11日 20:46
 * @version: V1.0
 */
@Service("DailyCommentService")
public class DailyCommentServiceImpl extends BaseServiceImpl<DailyComment, String> implements DailyCommentService {

    /** jpaRepository dailyCommentRepository */
    private final DailyCommentRepository dailyCommentRepository;

    /**
     * @Description: constructor
     * @param dailyCommentRepository autowired
     */
    @Autowired
    public DailyCommentServiceImpl(DailyCommentRepository dailyCommentRepository) {
        super.setRepository(dailyCommentRepository);
        this.dailyCommentRepository = dailyCommentRepository;
    }

    @Override
    public List<DailyComment> queryAll() {
        return dailyCommentRepository.findAll();
    }

}
