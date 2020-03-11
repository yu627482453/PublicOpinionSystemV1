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

    /**
     * @Description: set the repository
     * @param jpaRepository jpaRepository
     */
    public void setRepository(JpaRepository<T, E> jpaRepository);

    /**
     * @Description: query vo
     * @param id id
     * @return vo (Entity)
     */
    public T queryVO(E id);

    /**
     * @Description: query vos
     * @param ids E[] ids
     * @return list<VO>
     */
    public List<T> queryAll(E[] ids);

    /**
     * @Description: delete the vo
     * @param vo vo -> Entity
     * @return boolean
     */
    public boolean deleteVO(T vo);

    /**
     * @Description: delete vos
     * @param vos vos -> list<Entity>
     */
    public void deleteAll(List<T> vos);

    /**
     * @Description: update vo
     * @param vo vo -> Entity
     * @return boolean
     */
    public boolean updateVO(T vo);

    /**
     * @Description: updateAll vos
     * @param vos List<Entity>
     */
    public void updateAll(List<T> vos);

    /**
     * @Description: if exists
     * @param id id -> Entity
     * @return boolean
     */
    public boolean isExist(E id);

}
