package org.zigui.ice.service;

import org.zigui.ice.service.impl.HelloService;

/**
 * 服务端
 * Created by Admin on 2017/4/11.
 */
@SuppressWarnings("Duplicates")
public class Service {
    public static void main(String[] args) {
        int status = 0;
        Ice.Communicator ic = null;
        try {
            ic = Ice.Util.initialize(args);
            Ice.ObjectAdapter adapter =
                    ic.createObjectAdapterWithEndpoints("HelloAdapter", "default -p 10000");


            Ice.Object helloObj = new HelloService();
            adapter.add(helloObj, ic.stringToIdentity("Hello"));
            System.out.println("---------服务启动---------");
            adapter.activate();
            ic.waitForShutdown();
        } catch (Ice.LocalException e) {
            e.printStackTrace();
            status = 1;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            status = 1;
        }
        if (ic != null) {
            try {
                ic.destroy();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                status = 1;
            }
        }
        System.exit(status);
    }
}
