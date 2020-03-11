package com.nex.dao;

import com.nex.entity.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.dao
 * @Description: Point repository
 * @author: nero
 * @date: 2020年03月11日 10:47
 * @version: V1.0
 */
@Repository
public interface PointRepository extends JpaRepository<Point, Integer> {

    List<Point> findByPart(int part);
}
