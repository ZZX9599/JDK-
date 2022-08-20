package com.zzx.service.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: ZZX
 * @Date: 2022/6/24 10:42
 */
public class MyProxyFactory {

    /**
     * 目标不是接口，而是实现了接口
     *
     * @param target
     * @return
     */
    public Object returnProxyObjectNotInterface(Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                System.out.println("接口实现类代理对象执行");

                System.out.println("唱歌之前先跳一会");

                method.invoke(target, args);

                System.out.println("唱完了，打会篮球");

                return "动态代理成功！";
            }
        });
    }

    /**
     * 返回动态代理对象，目标是接口
     * @param myClass
     * @return
     */
    public Object returnProxyObjectIsInterface(Class myClass) {
        return Proxy.newProxyInstance(myClass.getClassLoader(), new Class[]{myClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                System.out.println("接口代理对象执行");

                return null;
            }
        });
    }
}