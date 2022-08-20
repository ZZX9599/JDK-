package com.zzx.service.test;

import com.zzx.service.Service;
import com.zzx.service.impl.ServiceImpl02;
import com.zzx.service.proxy.MyProxyFactory;

/**
 * @Author: ZZX
 * @Date: 2022/6/24 10:48
 */
public class MyTest {
    public static void main(String[] args) {

        MyProxyFactory myProxyFactory = new MyProxyFactory();

        Service service01=(Service) myProxyFactory.returnProxyObjectNotInterface(new ServiceImpl02());

        service01.sing();

        System.out.println("================================================");

        Service service02 = (Service) myProxyFactory.returnProxyObjectIsInterface(Service.class);

        service02.sing();

    }
}
