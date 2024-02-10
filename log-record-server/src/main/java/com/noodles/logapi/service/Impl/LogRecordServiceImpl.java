package com.noodles.logapi.service.Impl;

import com.noodles.logapi.beans.LogRecordOps;
import com.noodles.logapi.beans.User;
import com.noodles.logapi.service.LogRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: noodles
 * @Date: 2022/01/14 11:37
 */
@Service
public class LogRecordServiceImpl implements LogRecordService<User> {
    @Override
    public int record(LogRecordOps logRecordOps) {
        System.out.println("save [" + logRecordOps + "]");
        return 0;
    }

    @Override
    public User query(User user) {
        return null;
    }

    @Override
    public List<User> queryList(User user) {
        return null;
    }
}
