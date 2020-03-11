package com.nex.dto;

import java.util.List;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.dto
 * @Description: TODO
 * @author: nero
 * @date: 2020年03月11日 15:51
 * @version: V1.0
 */
public class BarChartDTO {

    private List<String> x;
    private List<Integer> data1;
    private List<Integer> data2;
    private List<Integer> data3;

    public BarChartDTO(List<String> x, List<Integer> data1, List<Integer> data2, List<Integer> data3) {
        this.x = x;
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;
    }

    @Override
    public String toString() {
        return "BarChartDTO{" +
                "x=" + x +
                ", data1=" + data1 +
                ", data2=" + data2 +
                ", data3=" + data3 +
                '}';
    }

    public List<String> getX() {
        return x;
    }

    public void setX(List<String> x) {
        this.x = x;
    }

    public List<Integer> getData1() {
        return data1;
    }

    public void setData1(List<Integer> data1) {
        this.data1 = data1;
    }

    public List<Integer> getData2() {
        return data2;
    }

    public void setData2(List<Integer> data2) {
        this.data2 = data2;
    }

    public List<Integer> getData3() {
        return data3;
    }

    public void setData3(List<Integer> data3) {
        this.data3 = data3;
    }
}
