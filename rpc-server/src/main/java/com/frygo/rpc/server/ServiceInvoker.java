package com.frygo.rpc.server;

import com.frygo.rpc.Request;
import com.frygo.rpc.common.utils.ReflectionUtils;

/**
 * 调用具体服务
 * @author frygo
 * @Create 2020--05-11 17:32
 */
public class ServiceInvoker {
    public Object invoke(ServiceInstance instance, Request request){
        return ReflectionUtils.invoke(instance.getTarget(),
                instance.getMethod(), request.getParameters());

    }
}
