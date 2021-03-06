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
// Generated from file `Hello.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package org.zigui.ice.face.hello;

public final class IHelloHolder extends Ice.ObjectHolderBase<IHello>
{
    public
    IHelloHolder()
    {
    }

    public
    IHelloHolder(IHello value)
    {
        this.value = value;
    }

    public void
    patch(Ice.Object v)
    {
        if(v == null || v instanceof IHello)
        {
            value = (IHello)v;
        }
        else
        {
            IceInternal.Ex.throwUOE(type(), v);
        }
    }

    public String
    type()
    {
        return _IHelloDisp.ice_staticId();
    }
}
