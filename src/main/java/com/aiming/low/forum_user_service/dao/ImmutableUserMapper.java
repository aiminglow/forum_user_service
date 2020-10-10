package com.aiming.low.forum_user_service.dao;

import com.aiming.low.forum_user_service.entity.ImmutableUser;

import java.util.HashSet;
import java.util.List;


public interface ImmutableUserMapper {
    List<ImmutableUser> selectUserListByUserIdSet(HashSet<Long> userIds);
}
