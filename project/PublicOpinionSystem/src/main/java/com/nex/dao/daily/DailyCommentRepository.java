package com.nex.dao.daily;

import com.nex.entity.daily.DailyComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.dao.daily
 * @Description: Daily Comment Repository
 * @author: nero
 * @date: 2020年03月11日 20:39
 * @version: V1.0
 */
@Repository
public interface DailyCommentRepository extends JpaRepository<DailyComment, String> {

}
