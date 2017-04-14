[["java:package:org.zigui.ice.face"]]

module hello {

    enum Color {Red, Yellow, Blue};

    struct Person {
        string name;
        int age;
        Color color;
    };

    /**
     *
     */
    interface IComplexInterface {
        /**
         *
         */
         Person visit(Person person, optional(1) bool ageIncr);
    };
};