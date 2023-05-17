package com.garbage.sorting.controller;

import com.garbage.sorting.common.AjaxResult;
import com.garbage.sorting.domain.User;
import com.garbage.sorting.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 用户服务
 *
 * @author wanghongjie
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    public UserService userService;

    @PostMapping("/createUser")
    public AjaxResult createUser(@RequestBody User user) {
        user.setCreateTime(new Date());
        user.setIntegral(0);
        userService.save(user);
        return AjaxResult.success();
    }
}
