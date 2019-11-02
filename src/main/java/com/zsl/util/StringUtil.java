package com.zsl.util;

/**
 * @author zsl
 * @date 2019/11/2
 * String 工具类
 */
public class StringUtil {

    /**
     * 判断是否为空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        if (null!=str && str.length()>0){
            return false;
        }else {
            return true;
        }
    }
}
