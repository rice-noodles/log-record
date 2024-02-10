package com.noodles.logapi.service;

import com.noodles.logapi.beans.LogRecordOps;

import java.util.List;

/**
 * @Author: noodles
 * @Date: 2022/01/13 11:55
 */
public interface LogRecordService<T> {
    int record(LogRecordOps logRecordOps);

    T query(T t);

    List<T> queryList(T t);
}
