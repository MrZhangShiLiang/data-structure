package com.zsl.io;

import java.io.*;
import java.util.LinkedList;

/**
 * @author zsl
 * @date 2019/10/6
 */
public class BufferedOutputFile {


    public static void main(String[] args) {
        try {
            String file = "D:\\schoolStudio\\basic-learning\\data-structure\\src\\main\\java\\com\\zsl\\io\\test.out";
            BufferedReader bufferedReader = new BufferedReader(new StringReader(BufferedInputFile.get("D:\\schoolStudio\\basic-learning\\data-structure\\src\\main\\java\\com\\zsl\\io\\DirList.java")));

            PrintWriter out = new PrintWriter(new FileWriter(file));

            int count = 1;
            String s;

            while ((s=bufferedReader.readLine())!=null){
                out.println(count++ +":"+s);
            }
            out.close();
            BufferedInputFile.get(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
