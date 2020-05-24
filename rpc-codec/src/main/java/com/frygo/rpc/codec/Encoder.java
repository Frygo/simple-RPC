package com.frygo.rpc.codec;

/**
 * 序列化
 * @author frygo
 * @Create 2020--05-11 14:17
 */
public interface Encoder {
    byte[] encode(Object object);
}
