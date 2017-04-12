package org.zigui.ice.service.example;

import Ice.BooleanHolder;
import Ice.Current;
import Ice.IntHolder;
import org.zigui.ice.example._IParameterDisp;

/**
 * 多参数服务实现
 * Created by Admin on 2017/4/12.
 */
public class ParameterServiceImpl extends _IParameterDisp {
    @Override
    public boolean reg(String name, int age, Current __current) {
        System.out.println("reg() 获得输入参数：name = " + name + " age = " + age);
        return true;
    }

    @Override
    public void unReg(String name, IntHolder count, BooleanHolder successful, Current __current) {
        System.out.println("unReg() 获得输入参数：name = " + name);
        System.out.println("正在设置输出参数");
        count.value = 997;
        successful.value = true;
        System.out.println("输出参数设置完毕");
    }
}
