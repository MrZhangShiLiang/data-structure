package com.zsl.string;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;

/**
 * @author zsl
 * @date 2019/12/19
 */
public class StringTest {
    private double total = 0d;
    private Formatter formatter = new Formatter(System.out);

    @Test
    public void test3(){
        String str = "+2";
        boolean b = str.matches("\\+?");
        System.out.println(b);
    }

    @Test
    public void test2(){
        String asd = String.format("%-12s %d%% %c", "asd", 12,456);
        System.out.println(asd);
    }

    @Test
    public void test1(){
        File file = new File("D:\\schoolStudio\\basic-learning\\data-structure\\src\\main\\java\\com\\zsl\\string\\test.txt");
        try {
            Formatter f = new Formatter(file);
            f.format("%-15s %5s %10s\n","item","Qty","Price");
            f.format("%-15s %5s %10s\n","----","----","----");

            f.flush();
            f.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        formatter.format("%-15s %5s %10s\n","item","Qty","Price");
        formatter.format("%-15s %5s %10s\n","----","----","----");
    }
}
