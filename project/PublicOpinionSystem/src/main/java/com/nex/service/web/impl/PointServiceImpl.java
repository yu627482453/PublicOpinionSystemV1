package com.nex.service.web.impl;

import com.nex.dao.PointRepository;
import com.nex.entity.Point;
import com.nex.service.web.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.service.web.impl
 * @Description: Point Service Impl
 * @author: nero
 * @date: 2020年03月11日 10:51
 * @version: V1.0
 */
@Service("PointService")
public class PointServiceImpl extends BaseServiceImpl<Point, Integer> implements PointService {

    /** jpaRepository pointRepository */
    private final PointRepository pointRepository;

    /**
     * @Description: constructor
     * @param pointRepository autowired
     */
    @Autowired
    public PointServiceImpl(PointRepository pointRepository){
        super.setRepository(pointRepository);
        this.pointRepository = pointRepository;
    }

    /**
     * @Description: query by part
     * @param part 0: base, 1: day, 2: hour, 3: yes_day, 4: last_day, 5: week
     * @return List<Point>
     */
    @Override
    public List<Point> queryByPart(int part) {
        return this.pointRepository.findByPart(part);
    }
}
