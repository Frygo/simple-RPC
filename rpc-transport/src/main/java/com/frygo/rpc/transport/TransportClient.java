package com.frygo.rpc.transport;

import com.frygo.rpc.Peer;

import java.io.InputStream;

/**
 * 1.连接
 * 2.发送数据，并且等待响应
 * 3.关闭连接
 * @author frygo
 * @Create 2020--05-11 14:46
 */
public interface TransportClient {
    void connect(Peer peer);

    InputStream write(InputStream data);

    void close();
}
