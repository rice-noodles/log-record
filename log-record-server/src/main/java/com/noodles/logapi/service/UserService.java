package com.noodles.logapi.service;

import com.noodles.logapi.beans.User;

/**
 * @Author: noodles
 * @Date: 2022/01/11 12:30
 */
public interface UserService {
    String login(User user, int flag);
}
