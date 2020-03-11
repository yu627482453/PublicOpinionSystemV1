package com.nex.dao.blog;

import com.nex.entity.blog.YesDayBlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.dao.blog
 * @Description: Yes Day Blog Repository
 * @author: nero
 * @date: 2020年03月11日 17:56
 * @version: V1.0
 */
@Repository
public interface YesDayBlogRepository extends JpaRepository<YesDayBlog, String> {

    List<YesDayBlog> findByUser(String user);
}
