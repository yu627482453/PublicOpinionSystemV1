package com.nex.dto.daily;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.dto
 * @Description: DailyBlog DTO
 * @author: nero
 * @date: 2020年03月11日 20:05
 * @version: V1.0
 */
public class DailyBlogDTO {

    @JSONField(name = "id")
    private String id;
    @JSONField(name = "text")
    private String text;
    @JSONField(name = "reposts_count")
    private int repostsCount;
    @JSONField(name = "comments_count")
    private int commentsCount;
    @JSONField(name = "attitudes_count")
    private int attitudesCount;
    @JSONField(name = "created_at")
    private String createdAt;

    @Override
    public String toString() {
        return "DailyBlogDTO{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", repostsCount=" + repostsCount +
                ", commentsCount=" + commentsCount +
                ", attitudesCount=" + attitudesCount +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRepostsCount() {
        return repostsCount;
    }

    public void setRepostsCount(int repostsCount) {
        this.repostsCount = repostsCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public int getAttitudesCount() {
        return attitudesCount;
    }

    public void setAttitudesCount(int attitudesCount) {
        this.attitudesCount = attitudesCount;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
