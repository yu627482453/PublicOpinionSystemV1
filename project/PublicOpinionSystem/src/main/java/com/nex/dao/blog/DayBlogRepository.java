package com.nex.dao.blog;

import com.nex.entity.blog.DayBlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.dao
 * @Description: DayBlog Repository
 * @author: nero
 * @date: 2020年03月11日 14:22
 * @version: V1.0
 */
@Repository
public interface DayBlogRepository extends JpaRepository<DayBlog, String> {

    List<DayBlog> findByUser(String user);
}
