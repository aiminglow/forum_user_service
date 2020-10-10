package com.aiming.low.forum_user_service.controller;

import com.aiming.low.forum_user_service.entity.ImmutableUser;
import com.aiming.low.forum_user_service.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserControllerUT {
    private final UserServiceImpl userService = Mockito.mock(UserServiceImpl.class);
    private final UserController userController = new UserController(userService);

    @Test
    void searchUserListByUserIdSet() {
        HashSet<Long> userIds = new HashSet<>();
        userIds.add(1L);
        List<ImmutableUser> users = new ArrayList<>();
        users.add(ImmutableUser.builder().userId(1L).userName("aiming").build());

        when(userService.searchUserListByUserIdSet(userIds))
                .thenReturn(users);

        List<ImmutableUser> actualUsers = userController.searchUserListByUserIdSet(userIds);

        verify(userService, times(1)).searchUserListByUserIdSet(userIds);

        assertEquals(1, actualUsers.size());
        ImmutableUser user = actualUsers.get(0);
        assertEquals(1L, user.userId());
        assertEquals("aiming", user.userName());
    }
}