package com.zsl.structure_offer;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author zsl
 * @date 2019/11/24
 */
public class ArrayTest1 {

    /**
     * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
     * 数组中某些数字是重复的，但不知道有几个数字是重复的。
     * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
     * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，
     * 那么对应的输出是第一个重复的数字2。
     * @date 2019/11/24
     */

    private int[] numbers;

    @Before
    public void testBefore(){
        numbers = new int[]{2,3,1,0,2,5,3,4,5,2,1,0,3,4,6};
    }

    @Test
    public void test1(){
        /*List<Integer> list  = new ArrayList<>(numbers.length);
        Collections.addAll(list,numbers);

        for (Integer number : numbers) {
            if (list.contains(number)){
                System.out.println(number);
            }
        }*/
        int temp,count;
        List<Integer> list  = new ArrayList<>(numbers.length);
        for (int i = 0; i < numbers.length; i++) {
            temp = numbers[i];
            count = 1;

            if (list.size()==0 || !list.contains(temp)){
                list.add(temp);
            }else if (list.contains(temp)){
                continue;
            }

            for (int i1 = i+1; i1 < numbers.length; i1++) {

                if (temp == numbers[i1]){
                    count++;
                }

            }
            if (count!=1){
                System.out.println("重复数字为"+temp+",重复次数："+count);
            }
        }
        int [] duplication = new int[1];
        duplicate(numbers,numbers.length,duplication);
        System.out.println(duplication[0]);
    }

    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        int temp,count;
        for (int i=0;i<length;i++){
            temp = numbers[i];
            count = 1;
            for (int i1 = i+1; i1 < numbers.length; i1++) {

                if (temp == numbers[i1]){
                    count++;
                }

            }
            if (count!=1){

                duplication[0] = temp;
                return true;
            }
        }
        return false;
    }


    @Test
    public void test2(){
        System.out.println(ReverseSentence(" "));
    }
    /**
     * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，
     * 写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，
     * 但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这
     * 家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
     * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
     * @param str 串
     * @return 反转后
     * @date 2019/11/24
     */
    public static String ReverseSentence(String str) {

        String[] split = str.split(" ");
        if (split.length==0){
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            sb.append(split[i]);
            if (i!=0){
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}
