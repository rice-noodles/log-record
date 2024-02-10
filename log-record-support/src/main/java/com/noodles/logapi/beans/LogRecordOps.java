package com.noodles.logapi.beans;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @Author: noodles
 * @Date: 2022/01/12 21:43
 */
@Builder
@Data
public class LogRecordOps {
    private String content;

    private Boolean success;

    private String user;

    private Date date;
}
