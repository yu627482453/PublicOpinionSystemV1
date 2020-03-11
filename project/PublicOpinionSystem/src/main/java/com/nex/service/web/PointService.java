package com.nex.service.web;

import com.nex.entity.Point;

import java.util.List;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.service.web
 * @Description: Point Service interface
 * @author: nero
 * @date: 2020年03月11日 10:49
 * @version: V1.0
 */
public interface PointService extends BaseService<Point, Integer> {

    /**
     * @Description: query by part
     * @param part part id
     * @return List<Point>
     */
    List<Point> queryByPart(int part);

}
