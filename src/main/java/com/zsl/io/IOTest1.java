package com.zsl.io;

import org.junit.Test;

import java.io.*;

/**
 * @author zsl
 * @date 2019/11/12
 * 首先，java的io流是对文件的处理
 */
public class IOTest1 {

    private String path = "D:\\schoolStudio\\basic-learning\\data-structure\\src\\main\\java\\com\\zsl\\io\\io.txt";

    private String path2 = "D:\\schoolStudio\\basic-learning\\data-structure\\src\\main\\java\\com\\zsl\\io\\io2.txt";
    /**
     * 测试file文件类
     *
     */
    @Test
    public void test1(){
        try {
            File file =  new File("D:\\schoolStudio\\basic-learning\\data-structure\\src\\main\\java\\com\\zsl\\io\\io.txt");
            file.createNewFile();
            String name = file.getName();
            System.out.println(name);
            System.out.println(file.getTotalSpace()/(1024*1024*1024));
            System.out.println(file.getParent());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test2(){
        InputStream inputStream = null;
        try {

            inputStream = new FileInputStream(new File(this.path));

            int count2;
            byte[] bytes = new byte[1024];
            while ((count2=inputStream.read(bytes))>0){
                System.out.println(new String(bytes,0,count2));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (null!=inputStream){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test3(){
        try(
                FileInputStream fileInputStream= new FileInputStream(new File(this.path));
                FileOutputStream fileOutputStream=new FileOutputStream(new File(this.path2))
        ) {
            int hasRead;
            byte[] bytes = new byte[16];

            while ((hasRead=fileInputStream.read(bytes))>0){
                fileOutputStream.write(bytes,0,hasRead);
                System.out.println(hasRead);
                System.out.println("*****************");
                for (byte aByte : bytes) {
                    System.out.println(aByte);
                }
            }

            System.out.println("写入成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
