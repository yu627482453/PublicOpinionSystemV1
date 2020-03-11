package com.nex.controller;

import com.alibaba.fastjson.JSONObject;
import com.nex.dto.MsgDTO;
import com.nex.dto.UserDTO;
import com.nex.entity.SysUser;
import com.nex.service.web.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.controller
 * @Description: Login Controller
 * @author: nero
 * @date: 2020年03月10日 17:55
 * @version: V1.0
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object login(@RequestBody JSONObject jsonUserDTO) {

        try {
            String username = jsonUserDTO.get("username").toString();
            String password = jsonUserDTO.get("password").toString();

            SysUser vo = sysUserService.login(username, password);

            if (vo != null) {
                UserDTO user = new UserDTO(vo.getId(), vo.getUsername());
                MsgDTO msg = MsgDTO.success("succeed to login !", "/index.html");
                return JSONObject.toJSONString(msg);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

        return JSONObject.toJSONString(MsgDTO.failure("fail to login !"));
    }

}
