package org.zigui.ice.service.impl;

import Ice.Communicator;
import Ice.Current;
import Ice.ObjectAdapter;
import org.zigui.ice.face.hello._IHelloDisp;

import java.util.Arrays;

/**
 * 实现IceBox.Service接口的Hello服务示例
 * Created by Admin on 2017/4/11.
 */
public class HelloBoxService extends _IHelloDisp implements IceBox.Service {

    private ObjectAdapter adapter = null;

    @Override
    public void start(String serviceName, Communicator communicator, String[] strings) {
        System.err.println("获得启动的服务名称：" + serviceName);
        System.err.println("获得参数：" + Arrays.toString(strings));
//        adapter = communicator.createObjectAdapter(name);
        adapter = communicator.createObjectAdapterWithEndpoints(serviceName, "default -p 10000");
        Ice.Object helloObj = new HelloBoxService();
        adapter.add(helloObj, communicator.stringToIdentity("hello"));
        adapter.activate();
    }

    @Override
    public void stop() {
        adapter.deactivate();
    }

    @Override
    public String sayHello(String name, Current __current) {
        System.out.println("服务端接收到来自客户端的服务调用");
        return "Hello " + name + "! From IceBoxService.";
    }
}
