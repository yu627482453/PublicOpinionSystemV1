package com.nex.dao.blog;

import com.nex.entity.blog.WeekBlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.dao.blog
 * @Description: week blog Repository
 * @author: nero
 * @date: 2020年03月11日 17:58
 * @version: V1.0
 */
@Repository
public interface WeekBlogRepository extends JpaRepository<WeekBlog, String> {

    List<WeekBlog> findByUser(String user);

}
