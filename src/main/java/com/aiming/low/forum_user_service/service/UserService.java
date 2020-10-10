package com.aiming.low.forum_user_service.service;

import com.aiming.low.forum_user_service.entity.ImmutableUser;

import java.util.HashSet;
import java.util.List;

public interface UserService {
    List<ImmutableUser> searchUserListByUserIdSet(HashSet<Long> userIds);
}
