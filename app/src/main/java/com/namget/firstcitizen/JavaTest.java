package com.namget.firstcitizen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class JavaTest extends AppCompatActivity {

    private final int MAX = 1;

    public void javaFunction(int num, String name, double height) {
        //Todo
    }

    interface hello {
        void methodHello();

        void methodBye();
    }


    class ABC implements hello {
        String name = "";

        ABC(String name) {
            this.name = name;
        }

        @Override
        public void methodHello() {
            System.out.println("say hello ");
        }

        @Override
        public void methodBye() {
            System.out.println("say bye");
        }
    }

    class XYZ implements hello {
        ABC abc;

        XYZ(String name) {
            abc = new ABC(name);
        }

        @Override
        public void methodHello() {
            abc.methodHello();
        }

        @Override
        public void methodBye() {
            abc.methodBye();
        }
    }

//    class Alphabet()


    interface MoveBehavior {
        public void makeBehavior();
    }

    public class RunBehavior implements MoveBehavior {
        @Override
        public void makeBehavior() {
            System.out.println("make a run");
        }
    }

    public class FlyBehavior implements MoveBehavior {
        @Override
        public void makeBehavior() {
            System.out.println("make a fly");
        }
    }

    public class Duck {
        private MoveBehavior moveBehavior = new RunBehavior();

        public void makeBehavior() {
            this.moveBehavior.makeBehavior();
        }

        public void setMoveBehavior(MoveBehavior moveBehavior) {
            this.moveBehavior = moveBehavior;
        }
    }

    public void main() {
        Duck duck = new Duck();
        duck.makeBehavior();
        MoveBehavior newBehavior = new FlyBehavior();
        duck.setMoveBehavior(newBehavior);
        duck.makeBehavior();
    }

    class A {
        String a = "aaaa";
    }

    class B extends A{
        String b = "bbbb";

    }


    public static class LogUtil {
        public void e() {

        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



//        A a = new A();
//        B b = new B();

//        System.out.println("aa = " + (a instanceof B));
//        System.out.println("ab = " + (b instanceof A));




//        XYZ xyz = new XYZ("XYZ");
//        xyz.methodBye();
//
//        Toast.makeText(this, "a", Toast.LENGTH_SHORT).show();
//
//
//        javaFunction(100, "이재우", 180.0);
//
//        Integer myInteger = null;
//        if (myInteger != null) {
//            myInteger.toString();
//        }
//
//
////        try {
////            Integer myInteger = null;
////            myInteger.toString();
////        } catch (NullPointerException e) {
////            Log.e("error : ", e.toString());
////        }
//
//        String name = "이재우";
//        System.out.print(name + " 입니다.");


    }
}
