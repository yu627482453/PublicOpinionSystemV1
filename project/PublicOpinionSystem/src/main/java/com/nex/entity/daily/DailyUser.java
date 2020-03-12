package com.nex.entity.daily;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.entity.daily
 * @Description: Daily User
 * @author: nero
 * @date: 2020年03月11日 20:29
 * @version: V1.0
 */
@Entity
@Table(name = "ads_user_analysis")
public class DailyUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", length = 32)
    private String id;
    @Column(name = "screen_name")
    private String screenName;
    @Column(name = "text")
    private String text;
    @Column(name = "statuses_count")
    private int statusesCount;
    @Column(name = "verified")
    private int verified;
    @Column(name = "verified_reason")
    private String verifiedReason;
    @Column(name = "description")
    private String description;
    @Column(name = "gender")
    private int gender;
    @Column(name = "followers_count")
    private int followersCount;
    @Column(name = "follow_count")
    private int followCount;

    @Override
    public String toString() {
        return "DailyUser{" +
                "id='" + id + '\'' +
                ", screenName='" + screenName + '\'' +
                ", text='" + text + '\'' +
                ", statusesCount=" + statusesCount +
                ", verified=" + verified +
                ", verifiedReason='" + verifiedReason + '\'' +
                ", description='" + description + '\'' +
                ", gender=" + gender +
                ", followersCount=" + followersCount +
                ", followCount=" + followCount +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getStatusesCount() {
        return statusesCount;
    }

    public void setStatusesCount(int statusesCount) {
        this.statusesCount = statusesCount;
    }

    public int getVerified() {
        return verified;
    }

    public void setVerified(int verified) {
        this.verified = verified;
    }

    public String getVerifiedReason() {
        return verifiedReason;
    }

    public void setVerifiedReason(String verifiedReason) {
        this.verifiedReason = verifiedReason;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }

    public int getFollowCount() {
        return followCount;
    }

    public void setFollowCount(int followCount) {
        this.followCount = followCount;
    }
}
