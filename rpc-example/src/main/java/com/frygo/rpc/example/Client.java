package com.frygo.rpc.example;

import com.frygo.rpc.client.RpcClient;

/**
 * @author frygo
 * @Create 2020--05-11 20:18
 */
public class Client {
    public static void main(String[] args) {
        new Thread(new TestClient()).start();
        new Thread(new TestClient()).start();
    }
}
class TestClient implements Runnable{

    @Override
    public void run() {
        RpcClient client = new RpcClient();
        CalcService service = client.getProxy(CalcService.class);
        int r1 = service.add(1,2);
        int r2 = service.minus(3,2);
        int r3 = service.pow(2,4);
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
    }
}