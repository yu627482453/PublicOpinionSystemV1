package com.nex.dao.blog;

import com.nex.entity.blog.LastDayBlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.dao.blog
 * @Description: Last Day Blog Repository
 * @author: nero
 * @date: 2020年03月11日 17:57
 * @version: V1.0
 */
@Repository
public interface LastDayBlogRepository extends JpaRepository<LastDayBlog, String> {

    List<LastDayBlog> findByUser(String user);
}
