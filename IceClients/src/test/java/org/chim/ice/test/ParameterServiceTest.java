package org.chim.ice.test;

import Ice.BooleanHolder;
import Ice.IntHolder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.zigui.ice.example.IParameterPrx;
import org.zigui.ice.example.IParameterPrxHelper;

public class ParameterServiceTest extends BasicServiceTest {

    private IParameterPrx parameterPrx = null;

    @Before
    public void setUp() throws Exception {
        parameterPrx = IParameterPrxHelper.checkedCast(obtainDefaultObjectPrx());
        Assert.assertNotNull(parameterPrx);
    }

    @After
    public void tearDown() throws Exception {
        clearIc();
    }

    @Override
    public String obtainServiceImplClz() {
        return "ParameterServiceImpl";
    }

    @Test
    public void testReg() {
        boolean isRegSuccessful = parameterPrx.reg("chim", 23);
        Assert.assertEquals(true, isRegSuccessful);
    }

    @Test
    public void testUnReg() {
        IntHolder countHolder = new IntHolder(0);
        BooleanHolder successfulHolder = new BooleanHolder(false);
        parameterPrx.unReg("chim", countHolder, successfulHolder);

        Assert.assertEquals((Integer) 997, countHolder.value);
        Assert.assertEquals(true, successfulHolder.value);
    }
}
