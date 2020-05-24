package com.frygo.rpc.transport;

/**
 * 1.启动、监听
 * 2.接收请求
 * 3.关闭监听
 * @author frygo
 * @Create 2020--05-11 14:47
 */
public interface TransportServer {

    void init(int port,RequestHandler handler);

    void start();

    void stop();
}
