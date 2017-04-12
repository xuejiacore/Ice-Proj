// 定义一个枚举
const int PearValue = 7;
enum Fruit { Apple = 0, Pear = PearValue, Orange };

---------------------------------------------------------+
枚举使用
---------------------------------------------------------
module M {
    enum Color { red, green, blue };
};
module N {
    struct Pixel {
        M::Color c = M::blue;
    };
};