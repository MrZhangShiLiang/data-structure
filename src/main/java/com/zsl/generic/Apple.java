package com.zsl.generic;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zsl
 * @date 2019/9/3
    <li>获取类的 Class 对象实例<li/>
    <li>根据 Class 对象实例获取 Constructor 对象</li>
    <li>使用 Constructor 对象的 newInstance 方法获取反射类对象</li>
    <ul>而如果要调用某一个方法，则需要经过下面的步骤：</ul>
        <li>获取方法的 Method 对象</li>
        <li>利用 invoke 方法调用方法</li>
 */
public class Apple {
    private double price;

    public String name;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static void main(String[] args) {
        Apple apple = new Apple();
        apple.setPrice(90.9);
        System.out.println("苹果价格--->"+apple.getPrice());
        System.out.println("正射结束，反射开始...");

        try {
            Class appleClass = Class.forName("com.zsl.generic.Apple");
            Method setPrice = appleClass.getMethod("setPrice", double.class);
            Constructor constructor = appleClass.getConstructor();
            Object o = constructor.newInstance();
            setPrice.invoke(o,99.9);

            System.out.println("属性-----------------");
            //获取属性
            Field[] fields = appleClass.getFields();
            for (Field field : fields) {
                System.out.println(field.getName());
            }
            //
            System.out.println("获取全部属性");
            Field[] declaredFields = appleClass.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                System.out.println(declaredField.getName());
            }

            System.out.println("价格--------------------");
            Method getPrice = appleClass.getMethod("getPrice");
            double invoke = (double) getPrice.invoke(o);
            System.out.println(invoke);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
