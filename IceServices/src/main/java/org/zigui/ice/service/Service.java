package org.zigui.ice.service;

import Ice.Identity;
import Ice.Object;
import org.zigui.ice.service.example.ParameterServiceImpl;
import org.zigui.ice.service.impl.ComplexServiceImpl;
import org.zigui.ice.service.impl.HelloServiceImpl;

/**
 * 服务端
 * Created by Admin on 2017/4/11.
 */
@SuppressWarnings("Duplicates")
public class Service {

    private static class ServiceClass {
        public static Class<?> helloService = HelloServiceImpl.class;
        public static Class<?> parameterService = ParameterServiceImpl.class;
        public static Class<?> complexService = ComplexServiceImpl.class;
    }

    public static void main(String[] args) {

        // 设置需要提供的服务
        Class<?>[] servicesArray = new Class[]{ServiceClass.helloService, ServiceClass.parameterService, ServiceClass.complexService};

        int status = 0;
        Ice.Communicator ic = null;
        try {
            ic = Ice.Util.initialize(args);
            Ice.ObjectAdapter adapter = ic.createObjectAdapterWithEndpoints("HelloAdapter", "default -p 10000");

            /*
             * 自动加载指定的服务
             */
            StringBuilder serviceIdentityBuilder = new StringBuilder();
            int count = 0;
            for (Class<?> serviceClz : servicesArray) {
                Object serviceInstance = getServiceInstance(serviceClz);
                Identity identity = obtainIdentity(ic, serviceClz);
                if (serviceInstance != null && identity != null) {
                    adapter.add(serviceInstance, identity);
                    count++;
                    serviceIdentityBuilder.append(identity.name).append(",");
                }
            }

            StringBuilder serviceList = serviceIdentityBuilder.delete(serviceIdentityBuilder.length() - 1, serviceIdentityBuilder.length());
            System.out.println("---------服务启动[" + count + "/" + servicesArray.length + "]---------\n" + serviceList);

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

    /**
     * 获得需要提供服务的服务接口示例
     *
     * @param serviceClz 服务类
     * @return 返回服务实例
     */
    private static Ice.Object getServiceInstance(Class<?> serviceClz) {
        try {
            return (Ice.Object) serviceClz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获得服务的identity
     *
     * @param communicator -
     * @param serviceClz   服务类
     * @return 返回服务的identity
     */
    private static Identity obtainIdentity(Ice.Communicator communicator, Class<?> serviceClz) {
        return communicator.stringToIdentity(serviceClz.getSimpleName());
    }
}
