package com.aiming.low.forum_user_service.service.impl;

import com.aiming.low.forum_user_service.dao.ImmutableUserMapper;
import com.aiming.low.forum_user_service.entity.ImmutableUser;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceImplUT {
    private final ImmutableUserMapper userMapper = Mockito.mock(ImmutableUserMapper.class);
    private final UserServiceImpl userService = new UserServiceImpl(userMapper);

    @Test
    void searchUserListByUserIdSet() {
        HashSet<Long> userIds = new HashSet<>();
        userIds.add(1L);
        List<ImmutableUser> users = new ArrayList<>();
        users.add(ImmutableUser.builder().userId(1L).userName("aiming").build());

        when(userMapper.selectUserListByUserIdSet(userIds))
                .thenReturn(users);

        List<ImmutableUser> actualUsers = userService.searchUserListByUserIdSet(userIds);

        verify(userMapper, times(1)).selectUserListByUserIdSet(userIds);

        assertEquals(1, actualUsers.size());
        ImmutableUser user = actualUsers.get(0);
        assertEquals(1L, user.userId());
        assertEquals("aiming", user.userName());
    }
}