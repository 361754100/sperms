package com.smart.sperms.common;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @Descript 通用消息处理类
 * @Author fuyuanming
 * @Date 2019-02-19 14:04:05
 * @Version 1.0
 */
public class JsonResult extends HashMap<String, Object> implements Serializable {

    private static final long serialVersionUID = 5307162964635097012L;

    public JsonResult() {}

    /**
     * 返回成功消息
     * @return 成功消息
     */
    public static JsonResult success() {
        return JsonResult.success("操作成功");
    }

    /**
     * 返回成功消息
     * @param msg 内容
     * @return 成功消息
     */
    public static JsonResult success(String msg) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.put("msg", msg);
        jsonResult.put("code", 200);
        jsonResult.put("success", true);
        return jsonResult;
    }

    /**
     * 返回失败消息
     * @return 失败消息
     */
    public static JsonResult error() {
        return JsonResult.error( "操作失败", 1);
    }

    /**
     * 返回失败消息
     * @param msg 失败内容
     * @return 失败消息
     */
    public static JsonResult error(String msg) {
        return JsonResult.error(msg, 500);
    }

    /**
     * 返回失败消息
     * @param code 状态码
     * @param msg 失败内容
     * @return 失败消息
     */
    public static JsonResult error(String msg, int code) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.put("msg", msg);
        jsonResult.put("code", code);
        jsonResult.put("success", false);
        return jsonResult;
    }

    /**
     * 返回成功消息
     * @return 成功消息
     */
    public static String jsonSuccess() {
        return JsonResult.jsonSuccess("操作成功");
    }

    /**
     * 返回成功消息
     * @param msg 内容
     * @return 成功消息
     */
    public static String jsonSuccess(String msg) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.put("msg", msg);
        jsonResult.put("code", 200);
        jsonResult.put("success", true);
        return JSON.toJSONString(jsonResult);
    }

    /**
     * 返回失败消息
     * @return 失败消息
     */
    public static String jsonError() {
        return JsonResult.jsonError( "操作失败", 1);
    }

    /**
     * 返回失败消息
     * @param msg 失败内容
     * @return 失败消息
     */
    public static String jsonError(String msg) {
        return JsonResult.jsonError(msg, 500);
    }

    /**
     * 返回失败消息
     * @param code 状态码
     * @param msg 失败内容
     * @return 失败消息
     */
    public static String jsonError(String msg, int code) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.put("msg", msg);
        jsonResult.put("code", code);
        jsonResult.put("success", false);
        return JSON.toJSONString(jsonResult);
    }

}
