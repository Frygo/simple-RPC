package com.frygo.rpc.server;

import com.frygo.rpc.Request;
import com.frygo.rpc.ServiceDescriptor;
import com.frygo.rpc.common.utils.ReflectionUtils;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 管理rpc暴露的服务
 * @author frygo
 * @Create 2020--05-11 16:36
 */
@Slf4j
public class ServiceManager {
    //hashMap需要ServiceDescriptor 重写hashCode equals
    private Map<ServiceDescriptor,ServiceInstance> services;

    public ServiceManager(){
        this.services = new ConcurrentHashMap<>();
    }

    public <T> void register(Class<T> interfaceClass,T bean){
        Method[] methods = ReflectionUtils.getPublicMethods(interfaceClass);
        for (Method method : methods) {
            ServiceInstance sis  = new ServiceInstance(bean,method);
            ServiceDescriptor sdp = ServiceDescriptor.from(interfaceClass, method);
            services.put(sdp,sis);
            log.info("register service: {} {}",sdp.getClazz(),sdp.getMethod());
        }
    }

    public ServiceInstance lookup(Request request){
        ServiceDescriptor sdp = request.getServiceDescriptor();
        return services.get(sdp);
    }
}
