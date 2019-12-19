package com.zsl.my_enum;

import org.junit.Test;

/**
 * @author zsl
 * @date 2019/11/24
 */
public class EnumTest {

    @Test
    public void test1(){
        Season season = Season.SUMMER;
        System.out.println(season);
        for (Season value : Season.values()) {
            System.out.println(value);
            System.out.println(value.ordinal());
        }
    }
}
