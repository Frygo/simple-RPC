package com.frygo.rpc.codec;

/**
 * 反序列化
 * @author frygo
 * @Create 2020--05-11 14:16
 */
public interface Decoder {
    <T> T decode(byte[] bytes,Class<T> clazz);
}
