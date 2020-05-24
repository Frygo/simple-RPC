package com.frygo.rpc.client;

import com.frygo.rpc.Peer;
import com.frygo.rpc.codec.Decoder;
import com.frygo.rpc.codec.Encoder;
import com.frygo.rpc.codec.JsonDecoder;
import com.frygo.rpc.codec.JsonEncoder;
import com.frygo.rpc.transport.HTTPTransportClient;
import com.frygo.rpc.transport.TransportClient;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * @author frygo
 * @Create 2020--05-11 18:44
 */
@Data
public class RpcClientConfig {
    private Class<? extends TransportClient> transportClass = HTTPTransportClient.class;
    private Class<? extends Encoder> encoderClass = JsonEncoder.class;
    private Class<? extends Decoder> decoderClass = JsonDecoder.class;
    private Class<? extends TransportSelector> selectorClass =  RandomTransportSelector.class;
    private int connectionCount = 1;
    private List<Peer> servers = Arrays.asList(
      new Peer("127.0.0.1",3000)
    );
}
