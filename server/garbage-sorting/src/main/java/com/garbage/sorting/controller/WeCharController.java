package com.garbage.sorting.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.garbage.sorting.common.AjaxResult;
import com.garbage.sorting.domain.User;
import com.garbage.sorting.model.UserModel;
import com.garbage.sorting.service.UserService;
import com.garbage.sorting.service.WeCharService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Objects;

/**
 * @author wanghongjie
 */
@RestController
@RequestMapping("/weChar")
public class WeCharController {

    @Resource
    private WeCharService weCharService;

    @Resource
    private UserService userService;

    @GetMapping("/getOpenId")
    public AjaxResult getOpenId(@RequestParam("code") String code) {
        String openId = weCharService.getOpenId(code);
        UserModel userModel = new UserModel();
        if (StringUtils.hasText(openId)) {
            userModel.setOpenId(openId);
            LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(User::getOpenId, openId);
            User user = userService.getOne(wrapper);
            if (Objects.isNull(user)) {
                user = new User();
                user.setOpenId(openId);
                user.setCreateTime(new Date());
                userService.save(user);
            }
        }
        return AjaxResult.success(userModel);
    }
}
