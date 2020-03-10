package com.nex.dao;

import com.nex.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.dao
 * @Description: SysUser Repository
 * @author: nero
 * @date: 2020年03月10日 14:11
 * @version: V1.0
 */
@Repository
public interface SysUserRepository extends JpaRepository<SysUser, String> {

    public SysUser findByUsername(String username);
}
