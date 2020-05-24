package com.frygo.rpc;

import lombok.Data;

import java.io.Serializable;

/**
 * 表示RPC的返回
 * @author frygo
 * @Create 2020--05-11 13:05
 */
@Data
public class Response implements Serializable {
    /**
     * 服务返回编码，0-成功，非0失败
     */
    private int code;
    /**
     * 具体的错误信息
     */
    private String message = "ok";
    /**
     * 返回的数据
     */
    private Object data;
}
