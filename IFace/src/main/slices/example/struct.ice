// 定义一个结构体
struct TimeOfDay {
    short hour;         // 0 - 23
    short minute;       // 0 - 59
    short second;       // 0 - 59
};


---------------------------------------------------------+
结构体不允许进行嵌套定义，必须按照如下方式定义和使用
---------------------------------------------------------
struct Point {
    short x;
    short y;
};
struct TwoPoints {      // Legal (and cleaner!)
    Point coord1;
    Point coord2;
};


---------------------------------------------------------+
多种类型的嵌套
---------------------------------------------------------
struct Location {
    string name;
    Point pt;
    bool display = true;
    string source = "GPS";
};