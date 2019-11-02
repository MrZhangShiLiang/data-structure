package com.zsl.generic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zsl
 * @date 2019/9/3
 */
public class SimpleDynamicProxy {
    public static void consumer(Interface iface){
        iface.doSomething();
        iface.doSomethingElse("bonobo");
    }

    public static void main(String[] args) {
        RealObject realObject = new RealObject();
        consumer(realObject);

        Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(),
                new Class[]{Interface.class},
                new DynamicProcxyHandler(realObject));

        consumer(proxy);
        System.out.println(proxy);
    }
}


class DynamicProcxyHandler implements InvocationHandler{

    private Object proxied;

    public DynamicProcxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("******proxy:"+proxy.getClass()+",method"+method+",args:"+args);
        if (args != null){
            for (Object arg : args) {
                System.out.println(" "+arg);
            }
        }
        return method.invoke(proxied,args);
    }
}
