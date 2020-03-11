package com.nex.controller;

import com.alibaba.fastjson.JSONObject;
import com.nex.dto.MsgDTO;
import com.nex.dto.UserDTO;
import com.nex.entity.SysUser;
import com.nex.service.web.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.controller
 * @Description: TODO
 * @author: nero
 * @date: 2020年03月11日 8:23
 * @version: V1.0
 */
@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Object register(@RequestBody JSONObject registerDTO) {

        System.out.println(registerDTO.toJSONString());

        try {
            String username = registerDTO.get("username").toString();
            String password = registerDTO.get("password").toString();
            String email = registerDTO.get("email").toString();

            SysUser vo = sysUserService.register(username, password, email);

            if (vo != null) {
                UserDTO user = new UserDTO(vo.getId(), vo.getUsername());
                MsgDTO msg = MsgDTO.success("success to register ! ", "/index.html");
                return JSONObject.toJSONString(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSONObject.toJSONString(MsgDTO.failure("fail to register !"));
    }


}
