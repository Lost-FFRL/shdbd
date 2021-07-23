package com.tmmk.shdbd.effective.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO <功能详细描述>
 *
 * @author Lost
 * @version 4.10.0
 * @date 2021-03-05 9:27
 */
public enum BasicOperation implements Operation{
    PLUS("+") {@Override public double apply(double x, double y) { return x + y; }},
    MINUS("-")  {@Override public double apply(double x, double y) { return x - y; }},
    TIMES("*")  {@Override public double apply(double x, double y) { return x * y; }},
    DIVIDE("/")  {@Override public double apply(double x, double y) { return x / y; }};

    private final String symbol;

    BasicOperation(String symbol){
        this.symbol = symbol;
    }

    private static final Map<String, BasicOperation> stringToEnum = new HashMap<>();

    static {
        for (BasicOperation value : values()) {
            stringToEnum.put(value.toString(),value);
        }
    }

    @Override
    public String toString() {
        return symbol;
    }

    public BasicOperation fromString(String symbol){
        return stringToEnum.get(symbol);
    }


}
