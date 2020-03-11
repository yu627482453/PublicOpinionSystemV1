package com.nex.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.entity
 * @Description: Point
 * @author: nero
 * @date: 2020年03月11日 10:43
 * @version: V1.0
 */

@Entity
@Table(name="ads_point")
public class Point implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", length = 32)
    private int id;
    @Column(name = "point", length = 100)
    private String point;
    @Column(name = "part", length = 32)
    private int part;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public int getPart() {
        return part;
    }

    public void setPart(int part) {
        this.part = part;
    }

    @Override
    public String toString() {
        return "Point{" +
                "id=" + id +
                ", point='" + point + '\'' +
                ", part=" + part +
                '}';
    }
}
