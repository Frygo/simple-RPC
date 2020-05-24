package com.frygo.rpc.codec;

import com.alibaba.fastjson.JSON;

/**
 * @author frygo
 * @Create 2020--05-11 14:23
 */
public class JsonEncoder implements Encoder{
    @Override
    public byte[] encode(Object object) {
        return JSON.toJSONBytes(object);
    }
}
