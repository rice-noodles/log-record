package com.noodles.logapi.service.Impl;

import com.noodles.logapi.annotation.LogRecord;
import com.noodles.logapi.beans.User;
import com.noodles.logapi.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author: noodles
 * @Date: 2022/01/11 12:30
 */
@Service
public class UserServiceImpl implements UserService {

    @LogRecord(content = "你好，我是#{#user.username}, flag = #{#flag}")
    @Override
    public String login(User user, int flag) {
        return user.toString();
    }
}
