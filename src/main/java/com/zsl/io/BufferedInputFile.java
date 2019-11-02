package com.zsl.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

/**
 * @author zsl
 * @date 2019/10/6
 */
public class BufferedInputFile {

    public static String get(String fileName) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        StringBuilder stringBuilder = new StringBuilder();
        String str;

        LinkedList<String> linkedList = new LinkedList<>();
        while ((str = bufferedReader.readLine())!=null){
            stringBuilder.append(str+"\n");
            linkedList.add(str+"\n");
        }

        bufferedReader.close();

        for (int i = linkedList.size() - 1; i >= 0; i--) {
            System.out.println(linkedList.get(i));
        }
        System.out.println("------->");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        try {
            System.out.println(get("D:\\schoolStudio\\basic-learning\\data-structure\\src\\main\\java\\com\\zsl\\io\\DirList.java"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
