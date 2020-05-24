package com.frygo.rpc.codec;

import com.alibaba.fastjson.JSON;

/**
 * @author frygo
 * @Create 2020--05-11 14:22
 */
public class JsonDecoder implements Decoder{
    @Override
    public <T> T decode(byte[] bytes, Class<T> clazz) {
        return JSON.parseObject(bytes,clazz);
    }
}
