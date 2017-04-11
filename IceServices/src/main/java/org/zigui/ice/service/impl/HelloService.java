package org.zigui.ice.service.impl;

import Ice.Current;
import org.zigui.ice.face.hello._IHelloDisp;

/**
 * 服务实现类
 * Created by Admin on 2017/4/11.
 */
public class HelloService extends _IHelloDisp {

    @Override
    public String sayHello(String name, Current __current) {
        System.out.println("服务端接收到来自客户端的服务调用");
        return "Hello " + name + "!";
    }
}
