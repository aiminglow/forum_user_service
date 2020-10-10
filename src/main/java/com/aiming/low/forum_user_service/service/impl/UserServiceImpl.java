package com.aiming.low.forum_user_service.service.impl;

import com.aiming.low.forum_user_service.dao.ImmutableUserMapper;
import com.aiming.low.forum_user_service.entity.ImmutableUser;
import com.aiming.low.forum_user_service.service.UserService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description
 * @Author aiminglow
 */
@Service
public class UserServiceImpl implements UserService {
    private final ImmutableUserMapper userMapper;

    public UserServiceImpl(ImmutableUserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<ImmutableUser> searchUserListByUserIdSet(HashSet<Long> userIds) {
        List<ImmutableUser> users = userMapper.selectUserListByUserIdSet(userIds);
        return users;
    }
}
