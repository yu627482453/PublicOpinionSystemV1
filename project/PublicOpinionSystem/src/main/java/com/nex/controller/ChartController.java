package com.nex.controller;

import com.alibaba.fastjson.JSONObject;
import com.nex.dto.BarChartDTO;
import com.nex.dto.MsgDTO;
import com.nex.entity.KeyWord;
import com.nex.entity.blog.*;
import com.nex.service.web.KeyWordService;
import com.nex.service.web.blog.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.controller
 * @Description: Chart Controller
 * @author: nero
 * @date: 2020年03月11日 17:40
 * @version: V1.0
 */
@RestController
@RequestMapping("/chart")
public class ChartController {

    @Autowired
    private KeyWordService keyWordService;
    @Autowired
    private DayBlogService dayBlogService;
    @Autowired
    private HourBlogService hourBlogService;
    @Autowired
    private WeekBlogService weekBlogService;
    @Autowired
    private YesDayBlogService yesDayBlogService;
    @Autowired
    private LastDayBlogService lastDayBlogService;

    @RequestMapping(value = "/daybarchart", method = RequestMethod.GET)
    public Object dayBarChart(){

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

    @RequestMapping(value = "/daywordchart", method = RequestMethod.GET)
    public Object dayWordChart(){
        List<KeyWord> keyWords = this.keyWordService.queryByPart(1);

        Map<String, Integer> map = new HashMap<String, Integer>();

        for (KeyWord keyWord : keyWords) {
            map.put(keyWord.getKeyword(), keyWord.getValue());
        }
        MsgDTO msg = MsgDTO.success("success").setValue(JSONObject.toJSONString(map));

        return JSONObject.toJSONString(msg);
    }

    @RequestMapping(value = "/hourbarchart", method = RequestMethod.GET)
    public Object hourBarChart(){

        List<HourBlog> hourBlogs = this.hourBlogService.queryAll();

        List<String> x = new ArrayList<>();
        List<Integer> data1 = new ArrayList<>();
        List<Integer> data2 = new ArrayList<>();
        List<Integer> data3 = new ArrayList<>();

        for (HourBlog hourBlog : hourBlogs) {
            x.add(hourBlog.getMid());
            data1.add(hourBlog.getRepostsCount());
            data2.add(hourBlog.getCommentsCount());
            data3.add(hourBlog.getAttitudesCount());
        }

        BarChartDTO barChartDTO = new BarChartDTO(x, data1, data2, data3);

        MsgDTO msg =  MsgDTO.success("").setValue(JSONObject.toJSONString(barChartDTO));

        return JSONObject.toJSONString(msg);

    }

    @RequestMapping(value = "/hourwordchart", method = RequestMethod.GET)
    public Object hourWordChart(){
        List<KeyWord> keyWords = this.keyWordService.queryByPart(2);

        Map<String, Integer> map = new HashMap<String, Integer>();

        for (KeyWord keyWord : keyWords) {
            map.put(keyWord.getKeyword(), keyWord.getValue());
        }
        MsgDTO msg = MsgDTO.success("success").setValue(JSONObject.toJSONString(map));

        return JSONObject.toJSONString(msg);
    }

    @RequestMapping(value = "/weekbarchart", method = RequestMethod.GET)
    public Object weekBarChart(){

        List<WeekBlog> weekBlogs = this.weekBlogService.queryAll();

        List<String> x = new ArrayList<>();
        List<Integer> data1 = new ArrayList<>();
        List<Integer> data2 = new ArrayList<>();
        List<Integer> data3 = new ArrayList<>();

        for (WeekBlog weekBlog : weekBlogs) {
            x.add(weekBlog.getMid());
            data1.add(weekBlog.getRepostsCount());
            data2.add(weekBlog.getCommentsCount());
            data3.add(weekBlog.getAttitudesCount());
        }

        BarChartDTO barChartDTO = new BarChartDTO(x, data1, data2, data3);

        MsgDTO msg =  MsgDTO.success("").setValue(JSONObject.toJSONString(barChartDTO));

        return JSONObject.toJSONString(msg);

    }

    @RequestMapping(value = "/weekwordchart", method = RequestMethod.GET)
    public Object weekWordChart(){
        List<KeyWord> keyWords = this.keyWordService.queryByPart(3);

        Map<String, Integer> map = new HashMap<String, Integer>();

        for (KeyWord keyWord : keyWords) {
            map.put(keyWord.getKeyword(), keyWord.getValue());
        }
        MsgDTO msg = MsgDTO.success("success").setValue(JSONObject.toJSONString(map));

        return JSONObject.toJSONString(msg);
    }

    @RequestMapping(value = "/yesdaybarchart", method = RequestMethod.GET)
    public Object yesDayBarChart(){

        List<YesDayBlog> yesDayBlogs = this.yesDayBlogService.queryAll();

        List<String> x = new ArrayList<>();
        List<Integer> data1 = new ArrayList<>();
        List<Integer> data2 = new ArrayList<>();
        List<Integer> data3 = new ArrayList<>();

        for (YesDayBlog yesDayBlog : yesDayBlogs) {
            x.add(yesDayBlog.getMid());
            data1.add(yesDayBlog.getRepostsCount());
            data2.add(yesDayBlog.getCommentsCount());
            data3.add(yesDayBlog.getAttitudesCount());
        }

        BarChartDTO barChartDTO = new BarChartDTO(x, data1, data2, data3);

        MsgDTO msg =  MsgDTO.success("").setValue(JSONObject.toJSONString(barChartDTO));

        return JSONObject.toJSONString(msg);

    }

    @RequestMapping(value = "/yesdaywordchart", method = RequestMethod.GET)
    public Object yesDayWordChart(){
        List<KeyWord> keyWords = this.keyWordService.queryByPart(4);

        Map<String, Integer> map = new HashMap<String, Integer>();

        for (KeyWord keyWord : keyWords) {
            map.put(keyWord.getKeyword(), keyWord.getValue());
        }
        MsgDTO msg = MsgDTO.success("success").setValue(JSONObject.toJSONString(map));

        return JSONObject.toJSONString(msg);
    }

    @RequestMapping(value = "/lastdaybarchart", method = RequestMethod.GET)
    public Object lastDayBarChart(){

        List<LastDayBlog> lastDayBlogs = this.lastDayBlogService.queryAll();

        List<String> x = new ArrayList<>();
        List<Integer> data1 = new ArrayList<>();
        List<Integer> data2 = new ArrayList<>();
        List<Integer> data3 = new ArrayList<>();

        for (LastDayBlog lastDayBlog : lastDayBlogs) {
            x.add(lastDayBlog.getMid());
            data1.add(lastDayBlog.getRepostsCount());
            data2.add(lastDayBlog.getCommentsCount());
            data3.add(lastDayBlog.getAttitudesCount());
        }

        BarChartDTO barChartDTO = new BarChartDTO(x, data1, data2, data3);

        MsgDTO msg =  MsgDTO.success("").setValue(JSONObject.toJSONString(barChartDTO));

        return JSONObject.toJSONString(msg);

    }

    @RequestMapping(value = "/lastdaywordchart", method = RequestMethod.GET)
    public Object lastDayWordChart(){
        List<KeyWord> keyWords = this.keyWordService.queryByPart(5);

        Map<String, Integer> map = new HashMap<String, Integer>();

        for (KeyWord keyWord : keyWords) {
            map.put(keyWord.getKeyword(), keyWord.getValue());
        }
        MsgDTO msg = MsgDTO.success("success").setValue(JSONObject.toJSONString(map));

        return JSONObject.toJSONString(msg);
    }

}
