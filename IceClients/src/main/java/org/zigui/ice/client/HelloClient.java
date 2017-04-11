package org.zigui.ice.client;

import org.zigui.ice.face.hello.IHelloPrx;
import org.zigui.ice.face.hello.IHelloPrxHelper;

/**
 * 客户端调用调试
 * Created by Admin on 2017/4/11.
 */
@SuppressWarnings("Duplicates")
public class HelloClient {

    public static void main(String[] args) {
        int status = 0;
        Ice.Communicator ic = null;
        try {
            ic = Ice.Util.initialize(args);
            Ice.ObjectPrx base = ic.stringToProxy("hello:default -p 10000");
            IHelloPrx helloPrx = IHelloPrxHelper.checkedCast(base);

            if (helloPrx == null)
                throw new Error("Invalid proxy");

            System.err.println("来自服务端的调用返回：" + helloPrx.sayHello("HackerChim"));

        } catch (Ice.LocalException e) {
            e.printStackTrace();
            status = 1;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            status = 1;
        }
        if (ic != null) {
            // Clean up
            //
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
