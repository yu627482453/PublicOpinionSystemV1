package com.nex.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.entity
 * @Description: KeyWord Entity
 * @author: nero
 * @date: 2020年03月11日 16:32
 * @version: V1.0
 */
@Entity
@Table(name = "ads_keyword")
public class KeyWord implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", length = 32)
    private int id;
    @Column(name = "keyword", length = 100)
    private String keyword;
    @Column(name = "value", length = 100)
    private int value;
    @Column(name = "part", length = 100)
    private int part;

    @Override
    public String toString() {
        return "KeyWord{" +
                "id=" + id +
                ", keyword='" + keyword + '\'' +
                ", value=" + value +
                ", part=" + part +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getPart() {
        return part;
    }

    public void setPart(int part) {
        this.part = part;
    }
}
