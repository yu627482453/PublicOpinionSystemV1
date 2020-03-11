package com.nex.dto;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.dto
 * @Description: TODO
 * @author: nero
 * @date: 2020年03月11日 12:04
 * @version: V1.0
 */
public class FieldDTO {

    private String field;

    public FieldDTO(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
