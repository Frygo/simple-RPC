package com.frygo.rpc.transport;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 处理网络请求的handler
 * @author frygo
 * @Create 2020--05-11 14:54
 */
public interface RequestHandler {
    void onRequst(InputStream receive, OutputStream toResp);
}
