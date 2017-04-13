package org.chim.ice.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.zigui.ice.face.hello.Color;
import org.zigui.ice.face.hello.IComplexInterfacePrx;
import org.zigui.ice.face.hello.IComplexInterfacePrxHelper;
import org.zigui.ice.face.hello.Person;

/**
 * Created by Admin on 2017/4/13.
 */
public class ComplexServiceTest extends BasicServiceTest {

    IComplexInterfacePrx complexInterfacePrx = null;


    @Before
    public void setUp() throws Exception {
        this.complexInterfacePrx = IComplexInterfacePrxHelper.checkedCast(obtainDefaultObjectPrx());
        Assert.assertNotNull(this.complexInterfacePrx);
    }

    @After
    public void tearDown() throws Exception {
        this.clearIc();
    }

    @Test
    public void testVisit() throws Exception {
        Person person23 = new Person();
        person23.name = "John";
        person23.age = 23;

        Person visit23Person = this.complexInterfacePrx.visit(person23);
        Assert.assertEquals(Color.Blue, visit23Person.color);

        Person person45 = new Person();
        person45.name = "Chim";
        person45.age = 45;
        Person visit45Person = this.complexInterfacePrx.visit(person45);
        Assert.assertEquals(Color.Yellow, visit45Person.color);
    }

    @Override
    public String obtainServiceImplClz() {
        return "ComplexServiceImpl";
    }
}
