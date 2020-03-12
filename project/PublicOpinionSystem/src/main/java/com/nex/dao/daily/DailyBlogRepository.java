package com.nex.dao.daily;

import com.nex.entity.daily.DailyBlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.dao.daily
 * @Description: Daily Blog Repository
 * @author: nero
 * @date: 2020年03月11日 19:51
 * @version: V1.0
 */
@Repository
public interface DailyBlogRepository extends JpaRepository<DailyBlog, String> {

}
