package com.frygo.rpc.server;

import com.frygo.rpc.Request;
import com.frygo.rpc.ServiceDescriptor;
import com.frygo.rpc.common.utils.ReflectionUtils;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * @author frygo
 * @Create 2020--05-11 17:18
 */
public class ServiceManagerTest {

    @Test
    public void register() {
        ServiceManager serviceManager = new ServiceManager();

        serviceManager.register(TestInterface.class,new TestImpl());

    }

    @Test
    public void lookup() {
        ServiceManager serviceManager = new ServiceManager();
        serviceManager.register(TestInterface.class,new TestImpl());
        Method publicMethod = ReflectionUtils.getPublicMethods(TestInterface.class)[0];
        ServiceDescriptor from = ServiceDescriptor.from(TestInterface.class, publicMethod);
        Request request = new Request();
        request.setServiceDescriptor(from);
        ServiceInstance lookup = serviceManager.lookup(request);
        System.out.println(lookup);
    }
}