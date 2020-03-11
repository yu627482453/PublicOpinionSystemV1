package com.nex.entity.blog;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.entity.blog
 * @Description: Week Blog
 * @author: nero
 * @date: 2020年03月11日 17:53
 * @version: V1.0
 */
@Entity
@Table(name = "week")
public class WeekBlog implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "mid", length = 50)
    private String mid;
    @Column(name = "created_at")
    private String createdAt;
    @Column(name = "text")
    private String text;
    @Column(name = "text_length")
    private int textLength;
    @Column(name = "reposts_count")
    private int repostsCount;
    @Column(name = "comments_count")
    private int commentsCount;
    @Column(name = "attitudes_count")
    private int attitudesCount;
    @Column(name = "user", length = 50)
    private String user;

    @Override
    public String toString() {
        return "DayBlog{" +
                "mid='" + mid + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", text='" + text + '\'' +
                ", textLength=" + textLength +
                ", repostsCount=" + repostsCount +
                ", commentsCount=" + commentsCount +
                ", attitudesCount=" + attitudesCount +
                ", user='" + user + '\'' +
                '}';
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getTextLength() {
        return textLength;
    }

    public void setTextLength(int textLength) {
        this.textLength = textLength;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
