package com.zsl.io;

import org.junit.Test;

import java.io.*;

/**
 * @author zsl
 * @date 2019/11/17
 *
    FileInputStream/FileOutputStream  需要逐个字节处理原始二进制流的时候使用，效率低下
    FileReader/FileWriter 需要组个字符处理的时候使用
    StringReader/StringWriter 需要处理字符串的时候，可以将字符串保存为字符数组
    PrintStream/PrintWriter 用来包装FileOutputStream 对象，方便直接将String字符串写入文件
    Scanner　用来包装System.in流，很方便地将输入的String字符串转换成需要的数据类型
    InputStreamReader/OutputStreamReader ,  字节和字符的转换桥梁，在网络通信或者处理键盘输入的时候用
    BufferedReader/BufferedWriter ， BufferedInputStream/BufferedOutputStream ， 缓冲流用来包装字节流后者字符流，提升IO性能，BufferedReader还可以方便地读取一行，简化编程。
 * 参考URL：https://www.cnblogs.com/fysola/p/6123947.html
 */
public class IOReader1117 {

    private String path = "D:\\schoolStudio\\basic-learning\\data-structure\\src\\main\\java\\com\\zsl\\io\\io.txt";

    private String path2 = "D:\\schoolStudio\\basic-learning\\data-structure\\src\\main\\java\\com\\zsl\\io\\io2.txt";


    @Test
    public void test2(){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path2))) {
            String read;
            while (null!=(read=bufferedReader.readLine())){
                System.out.println(read);
                bufferedWriter.write(read);
            }


        }catch (Exception e){

        }
    }

    /**
     * 字符流
     */
    @Test
    public void test1(){
        try(Reader reader = new FileReader(path); Writer writer = new FileWriter(path2)){

            char[] readStr = new char[16];
            int hasRead=0;

            while ((hasRead=reader.read(readStr))>0){
                System.out.println(hasRead);
                System.out.println("**********");
                System.out.println(readStr);
                writer.write(readStr,0,hasRead);
            }

        }catch (Exception e){

        }
    }
}
