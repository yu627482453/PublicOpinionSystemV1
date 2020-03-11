package com.nex.service.web.impl;

import com.nex.service.web.BaseService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.service.web.impl
 * @Description: BaseService Impl
 * @author: nero
 * @date: 2020年03月10日 15:12
 * @version: V1.0
 */
public abstract class BaseServiceImpl<T, E> implements BaseService<T, E> {

    /** Repository baseRepository */
    private JpaRepository<T, E> baseRepository = null;

    /**
     * @Description: set the repository
     * @param jpaRepository jpaRepository
     */
    @Override
    public void setRepository(JpaRepository<T, E> jpaRepository) {
        this.baseRepository = jpaRepository;
    }

    /**
     * @Description: query vo
     * @param id id
     * @return vo (Entity)
     */
    @Override
    public T queryVO(E id) {
        T vo = (T) baseRepository.findById((E) id);
        return vo;
    }

    /**
     * @Description: query vos
     * @param ids E[] ids
     * @return list<VO>
     */
    @Override
    public List<T> queryAll(E[] ids) {

        List<T> vos = new ArrayList<T>();

        for (E id : ids){
            T vo = this.queryVO(id);
            vos.add(vo);
        }

        return vos;
    }

    /**
     * @Description: delete the vo
     * @param vo vo -> Entity
     * @return boolean
     */
    @Override
    public boolean deleteVO(T vo) {
        try {
            this.baseRepository.delete(vo);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * @Description: delete vos
     * @param vos vos -> list<Entity>
     */
    @Override
    public void deleteAll(List<T> vos) {
        for(T vo : vos){
            boolean result = deleteVO(vo);
        }
    }

    /**
     * @Description: update vo
     * @param vo vo -> Entity
     * @return boolean
     */
    @Override
    public boolean updateVO(T vo) {
        try {
            this.baseRepository.save(vo);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * @Description: updateAll vos
     * @param vos List<Entity>
     */
    @Override
    public void updateAll(List<T> vos) {

        for (T vo : vos) {
            this.updateVO(vo);
        }
    }

    /**
     * @Description: if exists
     * @param id id -> Entity
     * @return boolean
     */
    @Override
    public boolean isExist(E id) {
        if (this.baseRepository.findById(id) != null) {
            return true;
        }
        return false;
    }
}
