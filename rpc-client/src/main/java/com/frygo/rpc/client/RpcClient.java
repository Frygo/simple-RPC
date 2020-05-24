package com.frygo.rpc.client;

import com.frygo.rpc.codec.Decoder;
import com.frygo.rpc.codec.Encoder;
import com.frygo.rpc.common.utils.ReflectionUtils;

import java.lang.reflect.Proxy;

/**
 * @author frygo
 * @Create 2020--05-11 19:03
 */
public class RpcClient {
    private RpcClientConfig config;
    private Encoder encoder;
    private Decoder decoder;
    private TransportSelector selector;

    public RpcClient(){
        this(new RpcClientConfig());
    }

    public RpcClient(RpcClientConfig config){
        this.config = config;
        this.encoder = ReflectionUtils.newInstance(config.getEncoderClass());
        this.decoder = ReflectionUtils.newInstance(config.getDecoderClass());
        this.selector = ReflectionUtils.newInstance(config.getSelectorClass());
        this.selector.init(
                this.config.getServers(),
                this.config.getConnectionCount(),
                this.config.getTransportClass()
                );
    }

    public <T>T getProxy(Class<T> clazz){
        return (T)Proxy.newProxyInstance(
                getClass().getClassLoader(),
                new Class[] {clazz},
                new RemoteInvoker(clazz,encoder,decoder,selector)
        );
    }
}
