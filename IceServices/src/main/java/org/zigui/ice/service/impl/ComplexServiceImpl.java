package org.zigui.ice.service.impl;

import Ice.BooleanOptional;
import Ice.Current;
import org.zigui.ice.face.hello.Color;
import org.zigui.ice.face.hello.Person;
import org.zigui.ice.face.hello._IComplexInterfaceDisp;

/**
 * Created by Admin on 2017/4/13.
 */
public class ComplexServiceImpl extends _IComplexInterfaceDisp {

    @Override
    public Person visit(Person person, BooleanOptional ageIncr, Current __current) {
        System.err.println("当前Person:name => " + person.name + " age => " + person.age);
        if (person.age > 10 && person.age <= 30) {
            person.color = Color.Blue;
        } else if (person.age > 30 && person.age <= 50) {
            person.color = Color.Yellow;
        } else {
            person.color = Color.Red;
        }

        if (ageIncr.get()) {
            person.age++;
        }
        return person;
    }
}
