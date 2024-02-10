package com.noodles.logapi;

import cn.hutool.http.HttpUtil;

import java.util.*;
import java.util.concurrent.RecursiveTask;

/**
 * @Author: noodles
 * @Date: 2022/01/11 10:49
 */
public class Test {
    public static void main(String[] args) {
        /*String s = HttpUtil.get("http://127.0.0.1:8080/test");
        System.out.println(s); */
        String[] split = (24.0 + "").split("\\.");
        for (String s : split) {
            System.out.println(s);
        }
        StringBuilder stringBuilder = new StringBuilder();
        List<int[]> res = new ArrayList<>();
        int[][] ints = res.toArray(new int[][]{new int[0]});
        Thread thread = new Thread();
        RecursiveTask<Object> objectRecursiveTask = new RecursiveTask<>();
        objectRecursiveTask.fork();
        objectRecursiveTask.join();
    }
}
