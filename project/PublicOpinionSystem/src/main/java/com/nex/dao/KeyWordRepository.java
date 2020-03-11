package com.nex.dao;

import com.nex.entity.KeyWord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.dao
 * @Description: KeyWord Repository
 * @author: nero
 * @date: 2020年03月11日 16:40
 * @version: V1.0
 */
public interface KeyWordRepository extends JpaRepository<KeyWord, Integer> {

    List<KeyWord> findByPart(int part);

}
