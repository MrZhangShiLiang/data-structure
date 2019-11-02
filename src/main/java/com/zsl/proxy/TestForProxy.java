package com.zsl.proxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zsl
 * @date 2019/9/11
 * 测试学习动态代理
 *  静态代理：
 *      首先是要有一个接口，实际类和代理类都实现了这个接口，代理类以组合方式加强了实际类。
 *      这里以这样的一个场景：电影放映，影院放电影前可以卖爆米花，电影放映后可以放广告。模拟静态代理。
 *
 *  动态代理：
 *      1、同样实现接口，不同的是代理类要实现invocationHandler接口
 *          场景：卖酒，柜台可以卖茅台也可以卖五粮液
 */
public class TestForProxy {
    // 静态代理
    @Test
    public void test1(){
        new Cinema(new Movie()).play();
    }

    @Test
    public void test2(){
        SellMaoTai maoTai = new SellMaoTai();
        GuiTaiSellWine sellWine = new GuiTaiSellWine(maoTai);
        SellWine proxyInstance = (SellWine) Proxy.newProxyInstance(SellMaoTai.class.getClassLoader(), SellMaoTai.class.getInterfaces(), sellWine);
        proxyInstance.sell();
        System.out.println(proxyInstance.getClass().getName());

        System.out.println("==============================>");
        SellWuLiangYe wuLiangYe = new SellWuLiangYe();
        GuiTaiSellWine sellWine1 = new GuiTaiSellWine(wuLiangYe);
        SellWine o = (SellWine) Proxy.newProxyInstance(SellMaoTai.class.getClassLoader(), SellMaoTai.class.getInterfaces(), sellWine1);
        o.sell();
        System.out.println(o.getClass().getName());

    }
}
//=================================================
//-----------动态代理相关类
//=================================================
interface SellWine{
    void sell();
}

class SellMaoTai implements SellWine{
    @Override
    public void sell() {
        System.out.println("卖的是茅台酒。。。。");
    }
}

class SellWuLiangYe implements SellWine{
    @Override
    public void sell() {
        System.out.println("卖的是五粮液....");
    }
}

class GuiTaiSellWine implements InvocationHandler{

    //组合方式
    //动态代理不用指定是具体哪个，运行了才知道
    private Object obj;

    public GuiTaiSellWine(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("柜台卖酒咯");
        method.invoke(obj,args);
        System.out.println("柜台卖酒结束咯");
        return null;
    }
}


//=================================================
//-----------静态代理相关类
//=================================================
interface PlayMovie{
    void play();
}
//电影的实际播放类
class Movie implements PlayMovie{
    @Override
    public void play() {
        System.out.println("电影放映中。。。。");
    }
}

/**
 * 电影代理类，影院
 */
class Cinema implements PlayMovie{
    //组合的方式
    // 静态代理必须指定是哪个
    private Movie movie;

    public Cinema(Movie movie) {
        this.movie = movie;
    }

    //加强了电影放映类的功能
    @Override
    public void play() {
        System.out.println("电影放映前，卖爆米花咯。。。。。。");
        this.movie.play();//正式放电影
        System.out.println("电影放映完了，看点小广告呗。。。。");
    }
}

