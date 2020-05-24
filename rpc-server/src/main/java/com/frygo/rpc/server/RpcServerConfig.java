package com.frygo.rpc.server;

import com.frygo.rpc.codec.Decoder;
import com.frygo.rpc.codec.Encoder;
import com.frygo.rpc.codec.JsonDecoder;
import com.frygo.rpc.codec.JsonEncoder;
import com.frygo.rpc.transport.HTTPTransportServer;
import com.frygo.rpc.transport.TransportServer;
import lombok.Data;

/**
 * server配置
 * @author frygo
 * @Create 2020--05-11 16:26
 */
@Data
public class RpcServerConfig {
    private Class<? extends TransportServer> transportClass = HTTPTransportServer.class;
    private Class<? extends Encoder> encoderClass = JsonEncoder.class;
    private Class<? extends Decoder> decoerClass = JsonDecoder.class;
    private int port = 3000;
}
