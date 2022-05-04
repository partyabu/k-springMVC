package com.abucloud.controller;

import com.abucloud.dto.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author party-abu
 * @Date 2022/5/4 20:05
 */
@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("isOk")
    public String testOk() {
        return "ok" + "哈哈哈哈哈";
    }

    /**
     * todo
     *
     * @return
     */
    @PostMapping("user")
    public User queryUser() {
        return new User();
    }
}
