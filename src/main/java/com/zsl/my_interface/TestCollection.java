package com.zsl.my_interface;

import org.junit.Test;

import java.io.Serializable;
import java.util.*;

/**
 * @author zsl
 * @date 2019/12/9
 */
public class TestCollection {

    @Test
    public void test1(){
        Collection collection = new ArrayList();
        Collections.addAll(collection,1,2,3,4);
        System.out.println(collection.size());

        List<? extends Serializable> list = Arrays.asList(1, 2, 3, 4, "asd");
        for (Serializable serializable : list) {
            System.out.println(serializable.toString());
        }
    }
}
