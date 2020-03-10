package com.nex.service.spider;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.service.spider
 * @Description: Base Spider Service.
 * @author: nero
 * @date: 2020年03月02日 15:00
 * @version: V1.0
 */
public abstract interface BaseSpiderService {

    /**
     * @Description: setSectionName
     * @param sectionName section name
     */
    public void setSectionName(String sectionName);

    /**
     * @Description: set the spider before crawling.
     * @return true: succeed; false: failed.
     */
    public boolean setSpider();

    /**
     * @Description: crawl the index page.
     * @return true: succeed; false: failed.
     */
    public boolean crawlIndex();

    /**
     * @Description: crawl the comment page.
     * @param commentId id of the comment.
     * @return true: succeed; false: failed.
     */
    public boolean crawlComment(String commentId);

}
