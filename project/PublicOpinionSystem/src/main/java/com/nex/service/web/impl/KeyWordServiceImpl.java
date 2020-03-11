package com.nex.service.web.impl;

import com.nex.dao.KeyWordRepository;
import com.nex.entity.KeyWord;
import com.nex.service.web.KeyWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.service.web.impl
 * @Description: KeyWord Service Impl
 * @author: nero
 * @date: 2020年03月11日 16:43
 * @version: V1.0
 */
@Service("KeyWordService")
public class KeyWordServiceImpl extends BaseServiceImpl<KeyWord, Integer> implements KeyWordService {

    /** jpaRepository keyWordRepository */
    private final KeyWordRepository keyWordRepository;

    @Autowired
    public KeyWordServiceImpl(KeyWordRepository keyWordRepository) {
        super.setRepository(keyWordRepository);
        this.keyWordRepository = keyWordRepository;
    }

    /**
     * @Description: query by part
     * @param part part id
     * @return List<KeyWord>
     */
    @Override
    public List<KeyWord> queryByPart(int part) {
        return this.keyWordRepository.findByPart(part);
    }
}
