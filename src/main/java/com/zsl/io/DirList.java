package com.zsl.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author zsl
 * @date 2019/10/4
 * io 的学习使用
 */
public class DirList {

    public static void main(String[] args) {
        File file = new File(".");
        String[] list;

        if (args.length==0){
            list = file.list();
        }else{
            list = file.list(new MyFileNameFilter(args[0]));
        }
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for (String s : list) {
            System.out.println(s);
        }
    }
}

class MyFileNameFilter implements FilenameFilter{

    private Pattern pattern;  // 正则表达式


    public MyFileNameFilter(String regx) {
        pattern = Pattern.compile(regx);
    }

    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}
