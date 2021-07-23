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
public enum ExtendedOperation implements Operation {
    EXP("^") {
        @Override
        public double apply(double x, double y) {
            return Math.pow(x,y);
        }
    },
    REMAINDER("%") {
        @Override
        public double apply(double x, double y) {
            return x % y;
        }
    };

    private final String symbol;

    ExtendedOperation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }


}
