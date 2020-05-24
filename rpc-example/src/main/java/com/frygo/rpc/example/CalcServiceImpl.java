package com.frygo.rpc.example;

/**
 * @author frygo
 * @Create 2020--05-11 20:17
 */
public class CalcServiceImpl implements CalcService{
    @Override
    public int add(int a, int b) {
        return a + b;
    }
    @Override
    public int minus(int a, int b) {
        return a - b;
    }
    @Override
    public int pow(int x, int y) {
        return (int) Math.pow(x,y);
    }
}
