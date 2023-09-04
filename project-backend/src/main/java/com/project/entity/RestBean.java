package com.project.entity;


import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;

public record RestBean<T> (int code, T data, String msg){
    public static <T> RestBean<T> success(T data) {
        return new RestBean<>(200, data, "请求成功");
    }
    public static <T> RestBean<T> success() {
        return success(null);
    }

    public static <T> RestBean<T> failure(int code, String message) {
        return new RestBean<>(code, null, message);
    }

    //  编程Json格式返回前端
    public String asJsonString(){
        return JSONObject.toJSONString(this, JSONWriter.Feature.WriteNulls);
    }
}
