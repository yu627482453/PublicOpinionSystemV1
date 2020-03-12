package com.nex.dto.daily;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.dto
 * @Description: TODO
 * @author: nero
 * @date: 2020年03月11日 20:54
 * @version: V1.0
 */
public class DailyCommentDTO {

    @JSONField(name = "id")
    private String id;
    @JSONField(name = "text")
    private String text;
    @JSONField(name = "like_count")
    private int likeCount;
    @JSONField(name = "index_text")
    private String indexText;
    @JSONField(name = "created_at")
    private String createdAt;

    @Override
    public String toString() {
        return "DailyCommentDTO{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", likeCount=" + likeCount +
                ", indexText='" + indexText + '\'' +
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

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public String getIndexText() {
        return indexText;
    }

    public void setIndexText(String indexText) {
        this.indexText = indexText;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
