package com.nex.dto.daily;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.dto.daily
 * @Description: TODO
 * @author: nero
 * @date: 2020年03月11日 20:55
 * @version: V1.0
 */
public class DailyUserDTO {

    @JSONField(name = "id")
    private String id;
    @JSONField(name = "screen_name")
    private String screenName;
    @JSONField(name = "text")
    private String text;
    @JSONField(name = "statuses_count")
    private int statusesCount;
    @JSONField(name = "verified")
    private int verified;
    @JSONField(name = "verified_reason")
    private String verifiedReason;
    @JSONField(name = "description")
    private String description;
    @JSONField(name = "gender")
    private int gender;
    @JSONField(name = "followers_count")
    private int followersCount;
    @JSONField(name = "follow_count")
    private int followCount;

    @Override
    public String toString() {
        return "DailyUserDTO{" +
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
