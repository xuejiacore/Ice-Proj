package org.chim.ice.test;

import Ice.ObjectPrx;

/**
 * Ice 服务测试抽象类
 * Created by Admin on 2017/4/12.
 */
@SuppressWarnings({"Duplicates", "WeakerAccess"})
public abstract class BasicServiceTest {
    protected int status = 0;
    protected Ice.Communicator ic = null;
    protected String[] args = new String[]{};

    /**
     * 清空Ice.Communicator
     */
    protected void clearIc() {
        if (ic != null) {
            try {
                ic.destroy();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                status = 1;
            }
        }
    }

    /**
     * 根据id和端口好获得ObjectPrx
     *
     * @param id   id
     * @param port 端口
     */
    protected ObjectPrx obtainObjectPrx(String id, int port) {
        ic = Ice.Util.initialize(args);
        return ic.stringToProxy(id + ":default -p " + port);
    }

    /**
     * 根据id获得ObjectPrx，使用默认的端口号：10000
     *
     * @param id id
     */
    protected ObjectPrx obtainObjectPrx(String id) {
        return obtainObjectPrx(id, 10000);
    }

    /**
     * 使用实现累中制定的ServiceImplClz名称获得ObjectPrx，使用默认的端口好10000
     */
    protected ObjectPrx obtainDefaultObjectPrx() {
        return obtainObjectPrx(obtainServiceImplClz());
    }

    /**
     * 获得服务的名称id
     */
    public abstract String obtainServiceImplClz();
}
