package com.nex.dto;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.dto
 * @Description: TODO
 * @author: nero
 * @date: 2020年03月10日 20:07
 * @version: V1.0
 */
public class UserDTO {

    @JSONField(name = "id")
    private String id;
    @JSONField(name = "username")
    private String username;

    public UserDTO() {
    }

    public UserDTO(String id, String username) {
        this.id = id;
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
