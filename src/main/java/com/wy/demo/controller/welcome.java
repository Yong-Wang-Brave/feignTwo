package com.wy.demo.controller;


import com.wy.demo.entity.User;
import com.wy.demo.entity.UserReq;
import com.wy.demo.mapper.UserMapper;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Think
 * @Title: welocome
 * @ProjectName token-authentication
 * @Description: TODO
 * @date 2019/1/1815:41
 */
@RestController
@Log4j2
public class welcome {

    Logger logger = LoggerFactory.getLogger(com.wy.demo.controller.welcome.class);


    @Autowired
    UserMapper userMapper;

    @PostMapping("/update")
    public String welcome(@RequestBody UserReq userReq,@SessionAttribute(value = "wy",required = false)String wy) {
           log.info(wy);
        userMapper.updateUser(userReq);

        return "welcome token authentication";
    }
    @GetMapping("/get8081")
    public String welcome() {



        return "welcome8081";
    }
    @PostMapping("/getFeign")
    public User welcomeUser(@RequestBody String username) {
        User user =new User();
        user.setUsername(username);
        user.setPassword("222");

        return user;

    }
}
