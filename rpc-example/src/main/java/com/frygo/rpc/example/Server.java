package com.frygo.rpc.example;

import com.frygo.rpc.server.RpcServer;

/**
 * @author frygo
 * @Create 2020--05-11 20:18
 */
public class Server {
    public static void main(String[] args) {
        RpcServer rpcServer = new RpcServer();
        rpcServer.register(CalcService.class,new CalcServiceImpl());
        rpcServer.start();
    }
}
