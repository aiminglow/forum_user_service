package com.aiming.low.forum_user_service.controller;

import com.aiming.low.forum_user_service.entity.ImmutableUser;
import com.aiming.low.forum_user_service.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;

/**
 * @ClassName UserController
 * @Description
 * @Author aiminglow
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    /**
     * 这里的@RequestParam接收的是一个数组，那么url的参数经应该是"?userId=value1&userId=value2&userId=value3..."
     * 为了达到这种参数的效果，使用这个服务的feign客户端需要在接口方法中这样写：
     * feignMethod(@RequestParam HashSet<Long> userId)
     */
    @GetMapping("/list")
    public List<ImmutableUser> searchUserListByUserIdSet(@RequestParam HashSet<Long> userId) {
        List<ImmutableUser> users = userService.searchUserListByUserIdSet(userId);
        System.out.println("----------SUCCESS-----------");
        return users;
    }
}
