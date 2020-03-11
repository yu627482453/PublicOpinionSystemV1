package com.nex.dto;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.dto
 * @Description: //TODO
 * @author: nero
 * @date: 2020年03月10日 19:35
 * @version: V1.0
 */
public class MsgDTO {

    private int code;
    private String msg;
    private String url;

    public MsgDTO(int code, String msg, String url) {
        this.code = code;
        this.msg = msg;
        this.url = url;
    }

    @Override
    public String toString() {
        return "MsgDTO{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public static MsgDTO success(String msg, String url){
        return new MsgDTO(200, msg, url);
    }

    public static MsgDTO success(String msg){
        return new MsgDTO(200, msg, "");
    }

    public static MsgDTO success(int code, String msg, String url) {
        return new MsgDTO(code, msg, url);
    }

    public static MsgDTO success(int code, String msg) {
        return new MsgDTO(code, msg, "");
    }

    public static MsgDTO failure(String msg, String url) {
        return new MsgDTO(400, msg, url);
    }

    public static MsgDTO failure(String msg) {
        return new MsgDTO(400, msg, "");
    }

    public static MsgDTO failure(int code, String msg, String url) {
        return new MsgDTO(code,msg, url);
    }

    public static MsgDTO failure(int code, String msg) {
        return new MsgDTO(code, msg, "");
    }

    public static MsgDTO message(int code, String msg, String url) {
        return new MsgDTO(code, msg, url);
    }

    public static MsgDTO message(int code, String msg) {
        return new MsgDTO(code, msg, "");
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
