package com.smart.sperms.common;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.List;

/**
 * @Descript 分页数据消息封装类
 * @Author fuyuanming
 * @Date 2019-02-25 11:47:17
 * @Version 1.0
 */
public class PageJsonResult extends JsonResult {

    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 封装分页数据方法
     * @param data 分页列表数据
     * @param total 数据总数
     * @return json数据
     */
    public static String getData(List<?> data, long total) {
        PageJsonResult pageJsonResult = new PageJsonResult();
        pageJsonResult.put("list", data);
        pageJsonResult.put("total", total);
        return JSON.toJSONString(pageJsonResult);
    }

    /**
     * 封装登录用户信息
     * @param name 登录用户名
     * @param roleId 角色ID
     * @param msg 提示信息
     * @return
     */
    public static String getLoginUserData(String username, String name, int roleId, Serializable sessionId, String msg) {
        PageJsonResult pageJsonResult = new PageJsonResult();
        pageJsonResult.put("username", username);
        pageJsonResult.put("name", name);
        pageJsonResult.put("roleId", roleId);
        pageJsonResult.put("sessionId", sessionId);
        pageJsonResult.put("msg", msg);
        pageJsonResult.put("code", 200);
        pageJsonResult.put("success", true);
        return JSON.toJSONString(pageJsonResult);
    }

}
