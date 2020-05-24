package com.frygo.rpc.server;

import java.util.Map;

/**
 * @author frygo
 * @Create 2020--05-11 17:22
 */
public class TestImpl implements TestInterface{
    @Override
    public String hhh(int a, String b) {
        return "hhh";
    }

    @Override
    public int jjj(String c, Map<String, Integer> map) {
        return 132;
    }
}
