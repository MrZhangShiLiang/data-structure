package com.zsl.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zsl
 * @date 2019/9/2
 * 学习使用泛型
 */
public class TestForGeneric {

    /**
     * ? extends Animal 这种方式，问号代表不确定，只要是Animal或者Animal的子类都可以
     * 故，成为上界 考虑方式：有点类似向上转型
     * @param list
     */
    private static void biteList(List< ? extends  Animal> list){
        for (Animal animal : list) {
            animal.bite();
            if (animal instanceof Dog){
                System.out.println("---->"+Dog.class.getName());
            }
        }
    }

    private static void biteList2(List<? super Animal> list){
        for (Object o : list) {
            System.out.println(o.toString());
        }
    }

    public static void main(String[] args) {
        List<Animal> list = new ArrayList<>();
        list.add(new Dog());
        list.add(new Cat());
        list.add(new Animal());
        TestForGeneric.biteList(list);
        TestForGeneric.biteList2(list);
    }

}



class Animal{
    void bite(){
        System.out.println("animals...");
    }
}

class Dog extends Animal{
    @Override
    void bite(){
        System.out.println("dogs...");
    }
}

class Cat extends Animal{
    @Override
    void bite(){
        System.out.println("cat...");
    }
}
