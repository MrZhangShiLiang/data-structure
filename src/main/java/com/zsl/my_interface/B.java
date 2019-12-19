package com.zsl.my_interface;

/**
 * @author zsl
 * @date 2019/12/3
 */
public class B { //---->类嵌套接口
    interface Inf{
        void f();
    }

    public class InfImpl implements Inf{

        @Override
        public void f() {
            System.out.println("infImpl");
        }
    }

    /**
     * 可以为private
     */
    private interface InfPrivate{
        void infp();
    }

    public class InfpImpl implements InfPrivate{

        @Override
        public void infp() {
            System.out.println("infp...");
        }
    }

    public void testInfp(InfPrivate infPrivate){
        infPrivate.infp();
    }

    public static void main(String[] args) {
        B b = new B();
        b.testInfp(new InfPrivate() {
            @Override
            public void infp() {
                System.out.println("fuck.....");
            }
        });
        //b.testInfp(new InfpImpl());
    }

    public void testasdfasedf(){
        Tree tree = new Tree() {
            @Override
            public void water() {

            }
        };

        Tree.LittleTree littleTree = new Tree.LittleTree() {
            @Override
            public String sayHello() {
                return "fuck...";
            }
        };
    }
}

/**
 * 接口嵌套接口，里面的接口不能用private
 */
interface Tree{

    void water();

    public interface LittleTree{
        String sayHello();
    }

    interface BigTree{

    }
}

