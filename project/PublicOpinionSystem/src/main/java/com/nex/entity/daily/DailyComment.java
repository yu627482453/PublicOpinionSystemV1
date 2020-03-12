package com.nex.entity.daily;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.entity.daily
 * @Description: Daily Comment
 * @author: nero
 * @date: 2020年03月11日 20:29
 * @version: V1.0
 */
@Entity
@Table(name = "ads_comment_analysis")
public class DailyComment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", length = 32)
    private String id;
    @Column(name = "text")
    private String text;
    @Column(name = "like_count")
    private int likeCount;
    @Column(name = "index_text")
    private String indexText;
    @Column(name = "created_at")
    private String createdAt;

    @Override
    public String toString() {
        return "DailyComment{" +
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
