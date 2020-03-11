package com.nex.service.web;

import com.nex.entity.KeyWord;

import java.util.List;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.service.web
 * @Description: KeyWord Service interface
 * @author: nero
 * @date: 2020年03月11日 16:41
 * @version: V1.0
 */
public interface KeyWordService extends BaseService<KeyWord, Integer> {

    /**
     * @Description: query by part
     * @param part part id
     * @return List<Point>
     */
    List<KeyWord> queryByPart(int part);
}
