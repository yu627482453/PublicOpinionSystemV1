package com.nex.service.web;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.service.web
 * @Description: Base Service interface
 * @author: nero
 * @date: 2020年03月10日 14:39
 * @version: V1.0
 */
public interface BaseService<T, E> {

    public void setRepository(JpaRepository<T, E> jpaRepository);

    public T queryVO(E id);

    public List<T> queryAll(E[] id);

    public boolean deleteVO(T vo);

    public void deleteAll(List<T> vos);

    public boolean updateVO(T vo);

    public void updateAll(List<T> vos);

    public boolean isExist(E id);

}
