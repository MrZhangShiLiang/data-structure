package com.zsl.j8.lambda;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Formatter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zsl
 * @date 2019/12/19
 * 测试使用lambda表达式
 */
public class LambdaTest {

    private ArrayList<Student> students = null;

    @Before
    public void testBefore(){
        students = new ArrayList<>(5);
        Student stu1 = new Student(12,"hello1",78f);
        Student stu2 = new Student(20,"hello2",80f);
        Student stu3 = new Student(15,"hello3",60f);
        Student stu4 = new Student(8,"hello4",30f);
        Student stu5 = new Student(69,"hello5",99f);
        students.add(stu1); students.add(stu2); students.add(stu3); students.add(stu4); students.add(stu5);
    }

    @Test
    public void test1(){
        Formatter formatter = new Formatter(System.out);
        //1、lambda 遍历打印
        formatter.format("%-15s %10s \r\n","lambda表达式","测试Format一下");
        formatter.format("%-15s %10s \r\n","***********","************");
        formatter.format("%-15s %10s \r\n","1、lambda遍历","************");
        //students.forEach(stu-> System.out.println(stu));
        students.forEach(System.out::println);
        formatter.format("%-15s %10s \r\n","2、lambda改数据+遍历","************");
        // 2、给每个学生的分数再加10
        // 解释：peek()  对列表每个一类的属性进行操作，无返回
        // map() 对列表每个类的属性进行相关操作，并有返回值R
        students.stream().peek(student -> student.setGrade(10 + student.getGrade())).forEach(System.out::println);

        // 3、排序
        // 基本思路：常用的对某个实体类的属性进行排序时，我们一般实现Comparable<T>接口(这个T一般就是该实体类)，重写compare方法
        // 另一个方法：不实现接口，使用λ表达式，Comparator接口
        formatter.format("%-15s %10s \r\n","3、lambda排序(年龄升序)+遍历","************");
        students.stream().sorted((stu1,stu2)->stu1.getAge()-stu2.getAge()).forEach(System.out::println);
        formatter.format("%-15s %10s \r\n","4、lambda排序(成绩降序)+前三+遍历","************");
        List<Student> students1 = students.stream().sorted(Comparator.comparing(Student::getGrade).reversed()).limit(3).collect(Collectors.toList());
        students1.forEach(System.out::println);
        //
    }
}

class Student{
    private int age;

    private String name;

    private float grade;

    public Student(int age, String name, float grade) {
        this.age = age;
        this.name = name;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }
}
