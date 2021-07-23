package com.tmmk.shdbd.effective.enums;

/**
 * TODO <功能详细描述>
 *
 * @author Lost
 * @version 4.10.0
 * @date 2021-03-10 9:46
 */
public class OperationTest {
    public static void main(String[] args) {

    }

    private static <T extends Enum<T> & Operation> void test(Class<T> opSet, double x, double y) {

        for (Operation op : opSet.getEnumConstants()) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }
}
