package classes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;

public class HighOrderClass {

    private String privateString;

    private static String privateStaticString;

    public HighOrderClass() {
    }

    private HighOrderClass(String name) {
        InnerClass innerClass = new InnerClass();
        StaticInnerClass staticInnerClass = new StaticInnerClass();
    }

    private void m() {
        System.out.println("private method");
    }

    private static void f() {
        System.out.println("static method");
    }

    public class InnerClass {
        public InnerClass() {
        }

        void test() {
            privateString = "from Inner";
            privateStaticString = "from Inner too";
            new HighOrderClass("123");
            m();
            f();
        }
    }

    public static class StaticInnerClass {
        public static void main(String[] args) {
            privateStaticString = "from Inner too";
            new HighOrderClass("123");
            f();
        }
    }
}

class TestClasses {
    public static void main(String[] args) {
        HighOrderClass.InnerClass innerClass = new HighOrderClass().new InnerClass();
        HighOrderClass.StaticInnerClass staticClassInstance = new HighOrderClass.StaticInnerClass();
    }
}


