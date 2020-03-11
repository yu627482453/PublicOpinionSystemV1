package com.nex.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nex.dto.BarChartDTO;
import com.nex.dto.FieldDTO;
import com.nex.dto.MsgDTO;
import com.nex.entity.KeyWord;
import com.nex.entity.Point;
import com.nex.entity.blog.DayBlog;
import com.nex.service.web.KeyWordService;
import com.nex.service.web.PointService;
import com.nex.service.web.blog.DayBlogService;
import org.apache.avro.data.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.controller
 * @Description: Index Controller
 * @author: nero
 * @date: 2020年03月11日 11:01
 * @version: V1.0
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private PointService pointService;
    @Autowired
    private KeyWordService keyWordService;
    @Autowired
    private DayBlogService dayBlogService;

    @RequestMapping(value = "/keypoint", method = RequestMethod.GET)
    public Object keyPoint(@RequestParam(value = "count") Integer count){

        List<FieldDTO> fields = new ArrayList<>();

        int fieldCount = count;

        List<Point> points = pointService.queryByPart(0);

        if (points != null) {
            for (int i = 0; i < fieldCount; i++) {
                fields.add(new FieldDTO(points.get(i).getPoint()));
            }
        }

        String result = JSONArray.toJSONString(fields);

        MsgDTO msg = MsgDTO.success("success").setValue(result);

        return JSONObject.toJSONString(msg);

    }

    @RequestMapping(value = "/point", method = RequestMethod.GET)
    public Object point(@RequestParam(value = "count") Integer count){

        List<FieldDTO> fields = new ArrayList<>();

        int fieldCount = count;

        List<Point> points = pointService.queryByPart(0);
        points.addAll(pointService.queryByPart(1));

        for (int i = 0; i < fieldCount; i++) {
            fields.add(new FieldDTO(points.get(i).getPoint()));
        }

        String result = JSONArray.toJSONString(fields);

        MsgDTO msg = MsgDTO.success("success").setValue(result);

        return JSONObject.toJSONString(msg);
    }

    @RequestMapping(value = "/barchart", method = RequestMethod.GET)
    public Object barChart(){

        List<DayBlog> dayBlogs = this.dayBlogService.queryAll();

        List<String> x = new ArrayList<>();
        List<Integer> data1 = new ArrayList<>();
        List<Integer> data2 = new ArrayList<>();
        List<Integer> data3 = new ArrayList<>();

        for (DayBlog dayBlog : dayBlogs) {
            x.add(dayBlog.getMid());
            data1.add(dayBlog.getRepostsCount());
            data2.add(dayBlog.getCommentsCount());
            data3.add(dayBlog.getAttitudesCount());
        }

        BarChartDTO barChartDTO = new BarChartDTO(x, data1, data2, data3);

        MsgDTO msg =  MsgDTO.success("").setValue(JSONObject.toJSONString(barChartDTO));

        return JSONObject.toJSONString(msg);

    }

    @RequestMapping(value = "/wordchart", method = RequestMethod.GET)
    public Object wordChart(){

        List<KeyWord> keyWords = this.keyWordService.queryByPart(1);

        Map<String, Integer> map = new HashMap<String, Integer>();

        for (KeyWord keyWord : keyWords) {
            map.put(keyWord.getKeyword(), keyWord.getValue());
        }
        MsgDTO msg = MsgDTO.success("success").setValue(JSONObject.toJSONString(map));

        return JSONObject.toJSONString(msg);

    }

}
