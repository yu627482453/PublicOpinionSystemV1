package com.nex.dao.blog;

import com.nex.entity.blog.HourBlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.dao.blog
 * @Description: Hour Blog Repository
 * @author: nero
 * @date: 2020年03月11日 17:58
 * @version: V1.0
 */
@Repository
public interface HourBlogRepository extends JpaRepository<HourBlog, String> {

    List<HourBlog> findByUser(String user);
}
