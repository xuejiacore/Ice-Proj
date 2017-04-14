[["java:package:org.zigui.ice"]]

module example {

    /**
     * 输入输出参数
     */
    interface IParameter {
        /**
         * 单纯使用一个返回值的方式
         */
        bool reg(string name, int age);

        /**
         * 使用带输出参数的形式，其中，输入参数的位置必须要在输出参数之前
         */
        void unReg(string name, out int count, out bool successful);
    };
};