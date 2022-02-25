package com.tmmk.shdbd.leetcode;

import java.lang.reflect.Field;

/**
 * TODO <功能详细描述>
 *
 * @author Lost
 * @version 1.0.0
 * @date 2022-2-24 17:34
 */
public class Test {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Class cache = Integer.class.getDeclaredClasses()[0];
        Field myCache = cache.getDeclaredField("cache");
        myCache.setAccessible(true);

        Integer[] newCache = (Integer[])myCache.get(cache);
        newCache[132] = newCache[134];

        int a = 2;
        int b = a + a;
        System.out.printf("%d + %d = %d", a, a, b);
    }
}
