package com.zsl.my_interface;

/**
 * @author zsl
 * @date 2019/12/9
 */
public interface TestInterface {

    void f();

    class Test implements TestInterface{
        public static void main(String[] args) {
            Test t = new Test();
            t.f();
            Inside it = new Inside();
            it.say();
        }
        static void t(){
            System.out.println("ttttttt");
        }
        @Override
        public void f() {
            System.out.println("f()");
        }
        private static class Inside{
            public void say(){
                t();
                System.out.println("asdfasdfasdfasdf");
            }
        }
    }
}
