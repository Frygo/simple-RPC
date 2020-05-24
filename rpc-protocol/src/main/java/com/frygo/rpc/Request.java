package com.frygo.rpc;

import lombok.Data;

import java.io.Serializable;

/**
 * 表示PRC的一个请求
 * @author frygo
 * @Create 2020--05-11 13:03
 */
@Data
public class Request implements Serializable {
    private ServiceDescriptor serviceDescriptor;
    private Object[] parameters;
}
