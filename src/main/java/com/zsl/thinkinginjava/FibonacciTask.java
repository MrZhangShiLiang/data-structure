package com.zsl.thinkinginjava;

/**
 * 斐波那契數列 多綫程產生
 * F(1)=1，F(2)=1, F(n)=F(n-1)+F(n-2)（n>=3，n∈N*）
 * @author zsl
 * @date 2019/8/19
 */
public class FibonacciTask implements Runnable{

    private int n = 0;

    int temp = 0;

    private StringBuilder fibonacciStr = new StringBuilder();

    public FibonacciTask(int n) {
        this.n = n;
    }

    /**
     * 获取整数n个的斐波那契数列
     * @param n
     * @return
     */
    private int getFibocciStr(int n){
        if (n==0 || n==1){
            return 1;
        }else{
            return getFibocciStr(n-1)+getFibocciStr(n-2);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i <n ; i++) {
            this.fibonacciStr.append(String.valueOf(this.getFibocciStr(i))).append(" ");
        }
        System.out.println(n+"个数斐波那契数列为"+this.fibonacciStr.toString());
    }
}
