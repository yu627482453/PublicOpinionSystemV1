package com.nex.entity.daily;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.entity.daily
 * @Description: Daily blog
 * @author: nero
 * @date: 2020年03月11日 19:45
 * @version: V1.0
 */
@Entity
@Table(name = "ads_index_analysis")
public class DailyBlog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", length = 32)
    private String id;
    @Column(name = "text")
    private String text;
    @Column(name = "reposts_count")
    private int repostsCount;
    @Column(name = "comments_count")
    private int commentsCount;
    @Column(name = "attitudes_count")
    private int attitudesCount;
    @Column(name = "created_at")
    private String createdAt;

    @Override
    public String toString() {
        return "DailyBlog{" +
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
