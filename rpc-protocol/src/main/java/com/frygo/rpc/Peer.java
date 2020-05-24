package com.frygo.rpc;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 表示网络传输的一个端点
 * @author frygo
 * @Create 2020--05-11 12:59
 */
@Data
@AllArgsConstructor
public class Peer {
    private String host;
    private int port;
}
