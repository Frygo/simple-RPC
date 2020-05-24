package com.frygo.rpc.server;

import com.frygo.rpc.Request;
import com.frygo.rpc.Response;
import com.frygo.rpc.codec.Decoder;
import com.frygo.rpc.codec.Encoder;
import com.frygo.rpc.common.utils.ReflectionUtils;
import com.frygo.rpc.transport.RequestHandler;
import com.frygo.rpc.transport.TransportServer;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.PublicKey;

/**
 * @author frygo
 * @Create 2020--05-11 17:38
 */
@Slf4j
public class RpcServer {
    private RpcServerConfig config;
    private TransportServer net;
    private Encoder encoder;
    private Decoder decoder;
    private ServiceManager manager;
    private ServiceInvoker invoker;

    public RpcServer(){
        this(new RpcServerConfig());
    }

    public RpcServer(RpcServerConfig config){
        this.config = config;
        this.net = ReflectionUtils.newInstance(config.getTransportClass());
        this.net.init(config.getPort(),this.handler);
        this.decoder = ReflectionUtils.newInstance(config.getDecoerClass());
        this.encoder = ReflectionUtils.newInstance(config.getEncoderClass());
        this.manager = new ServiceManager();
        this.invoker = new ServiceInvoker();

    }
    public <T> void register(Class<T> interfaceClass,T bean){
        manager.register(interfaceClass,bean);
    }

    public void start(){
        this.net.start();
    }

    public void  stop(){
        this.net.stop();
    }

    private RequestHandler handler = new RequestHandler() {
        @Override
        public void onRequst(InputStream receive, OutputStream toResp) {
            Response response = new Response();
            try {
                byte[] bytes = IOUtils.readFully(receive, receive.available());
                Request request = decoder.decode(bytes,Request.class);
                log.info("get request: {}",request);
                ServiceInstance sis = manager.lookup(request);
                Object ret = invoker.invoke(sis, request);
                response.setData(ret);
            } catch (Exception e) {
                log.warn(e.getMessage(),e);
                response.setCode(1);
                response.setMessage("RpcServer got error: "
                        + e.getClass().getName()
                        + ":" + e.getMessage()
                );
            }finally {
                byte[] outBytes = encoder.encode(response);
                try {
                    toResp.write(outBytes);
                    log.info("response client");
                } catch (IOException e) {
                    log.warn( e.getMessage(),e);
                    e.printStackTrace();
                }

            }
        }
    };
}
