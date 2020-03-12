package com.nex.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nex.dto.daily.DailyBlogDTO;
import com.nex.dto.MsgDTO;
import com.nex.dto.daily.DailyCommentDTO;
import com.nex.dto.daily.DailyUserDTO;
import com.nex.entity.daily.DailyBlog;
import com.nex.entity.daily.DailyComment;
import com.nex.entity.daily.DailyUser;
import com.nex.service.web.daily.DailyBlogService;
import com.nex.service.web.daily.DailyCommentService;
import com.nex.service.web.daily.DailyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.controller
 * @Description: Table Controller
 * @author: nero
 * @date: 2020年03月11日 19:58
 * @version: V1.0
 */
@RestController
@RequestMapping("/table")
public class TableController {

    @Autowired
    private DailyBlogService dailyBlogService;
    @Autowired
    private DailyCommentService dailyCommentService;
    @Autowired
    private DailyUserService dailyUserService;

    @RequestMapping(value = "/dailyblogtable", method = RequestMethod.GET)
    public Object dailyBlogTable(){

        List<DailyBlogDTO> dailyBlogDTOs = new ArrayList<>();

        List<DailyBlog> dailyBlogs = this.dailyBlogService.queryAll();

        for (DailyBlog dailyBlog : dailyBlogs) {
            DailyBlogDTO dailyBlogDTO = new DailyBlogDTO();

            dailyBlogDTO.setId(dailyBlog.getId());
            dailyBlogDTO.setText(dailyBlog.getText());
            dailyBlogDTO.setRepostsCount(dailyBlog.getRepostsCount());
            dailyBlogDTO.setCommentsCount(dailyBlog.getCommentsCount());
            dailyBlogDTO.setAttitudesCount(dailyBlog.getAttitudesCount());
            dailyBlogDTO.setCreatedAt(dailyBlog.getCreatedAt());

            dailyBlogDTOs.add(dailyBlogDTO);
        }

        String result = JSONArray.toJSONString(dailyBlogDTOs);

        MsgDTO msg = MsgDTO.success("").setValue(result);

        return JSONObject.toJSONString(msg);

    }

    @RequestMapping(value = "/dailycommenttable", method = RequestMethod.GET)
    public Object dailyCommentTable(){

        List<DailyCommentDTO> dailyCommentDTOs = new ArrayList<>();

        List<DailyComment> dailyComments = this.dailyCommentService.queryAll();

        for (DailyComment dailyComment : dailyComments) {
            DailyCommentDTO dailyCommentDTO = new DailyCommentDTO();

            dailyCommentDTO.setId(dailyComment.getId());
            dailyCommentDTO.setText(dailyComment.getText());
            dailyCommentDTO.setLikeCount(dailyComment.getLikeCount());
            dailyCommentDTO.setIndexText(dailyComment.getIndexText());
            dailyCommentDTO.setCreatedAt(dailyComment.getCreatedAt());

            dailyCommentDTOs.add(dailyCommentDTO);
        }

        String result = JSONArray.toJSONString(dailyCommentDTOs);

        MsgDTO msg = MsgDTO.success("").setValue(result);

        return JSONObject.toJSONString(msg);
    }

    @RequestMapping(value = "/dailyusertable", method = RequestMethod.GET)
    public Object dailyUserTable() {

        List<DailyUserDTO> dailyUserDTOs = new ArrayList<>();

        List<DailyUser> dailyUsers = this.dailyUserService.queryAll();

        for (DailyUser dailyUser : dailyUsers) {
            DailyUserDTO dailyUserDTO = new DailyUserDTO();

            dailyUserDTO.setId(dailyUser.getId());
            dailyUserDTO.setDescription(dailyUser.getDescription());
            dailyUserDTO.setFollowCount(dailyUser.getFollowCount());
            dailyUserDTO.setFollowersCount(dailyUser.getFollowersCount());
            dailyUserDTO.setGender(dailyUser.getGender());
            dailyUserDTO.setScreenName(dailyUser.getScreenName());
            dailyUserDTO.setStatusesCount(dailyUser.getStatusesCount());
            dailyUserDTO.setText(dailyUser.getText());
            dailyUserDTO.setVerified(dailyUser.getVerified());
            dailyUserDTO.setVerifiedReason(dailyUser.getVerifiedReason());

            dailyUserDTOs.add(dailyUserDTO);
        }

        String result = JSONArray.toJSONString(dailyUserDTOs);

        MsgDTO msg = MsgDTO.success("").setValue(result);

        return JSONObject.toJSONString(msg);

    }

}
