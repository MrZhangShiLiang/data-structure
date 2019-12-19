package com.zsl.mycollection;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author zsl
 * @date 2019/12/10
 */
public class PriotyQueue {

    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(5,3,8,9,4,1,3,0);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(ints);
    }
}
