package org.chim.ice.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.zigui.ice.face.hello.IHelloPrx;
import org.zigui.ice.face.hello.IHelloPrxHelper;

public class HelloTest extends BasicServiceTest {

    private IHelloPrx helloPrx = null;

    @Before
    public void setUp() throws Exception {
        helloPrx = IHelloPrxHelper.checkedCast(obtainDefaultObjectPrx());
        Assert.assertNotNull(helloPrx);
    }

    @After
    public void tearDown() throws Exception {
        clearIc();
    }

    @Test
    public void testHello() {
        Assert.assertEquals("Hello HackerChim!", helloPrx.sayHello("HackerChim"));
        this.clearIc();
        Assert.assertEquals(0, status);
    }

    @Override
    public String obtainServiceImplClz() {
        return "HelloServiceImpl";
    }
}
