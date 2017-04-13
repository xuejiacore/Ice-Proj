// **********************************************************************
//
// Copyright (c) 2003-2016 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.6.3
//
// <auto-generated>
//
// Generated from file `ComplexInterface.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package org.zigui.ice.face.hello;

public enum Color implements java.io.Serializable
{
    
    Red(0),
    
    Yellow(1),
    
    Blue(2);

    public int
    value()
    {
        return __value;
    }

    public static Color
    valueOf(int __v)
    {
        switch(__v)
        {
        case 0:
            return Red;
        case 1:
            return Yellow;
        case 2:
            return Blue;
        }
        return null;
    }

    private
    Color(int __v)
    {
        __value = __v;
    }

    public void
    __write(IceInternal.BasicStream __os)
    {
        __os.writeEnum(value(), 2);
    }

    public static void
    __write(IceInternal.BasicStream __os, Color __v)
    {
        if(__v == null)
        {
            __os.writeEnum(org.zigui.ice.face.hello.Color.Red.value(), 2);
        }
        else
        {
            __os.writeEnum(__v.value(), 2);
        }
    }

    public static Color
    __read(IceInternal.BasicStream __is)
    {
        int __v = __is.readEnum(2);
        return __validate(__v);
    }

    private static Color
    __validate(int __v)
    {
        final Color __e = valueOf(__v);
        if(__e == null)
        {
            throw new Ice.MarshalException("enumerator value " + __v + " is out of range");
        }
        return __e;
    }

    private final int __value;
}