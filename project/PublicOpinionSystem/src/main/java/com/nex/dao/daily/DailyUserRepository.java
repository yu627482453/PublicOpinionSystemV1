package com.nex.dao.daily;

import com.nex.entity.daily.DailyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.dao.daily
 * @Description: Daily User Repository
 * @author: nero
 * @date: 2020年03月11日 20:40
 * @version: V1.0
 */
@Repository
public interface DailyUserRepository extends JpaRepository<DailyUser, String> {

}
