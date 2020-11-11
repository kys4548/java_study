package package6;

public class Main {
    public static void main(String[] args) {
        SuperClass superClass = new SuperClass();
        superClass.methodA();
        superClass.methodB();


        SuperClass subClass = new SubClass();
        subClass.methodA();
        subClass.methodB();

    }
}

class SuperClass {
    void methodA() {
        System.out.println("SuperClass A ");
    }

    static void methodB() {
        System.out.println("SuperClass B");
    }
}

class SubClass extends SuperClass {
    @Override
    void methodA() {
        System.out.println("SubClass A");
    }

    static void methodB() {
        System.out.println("SubClass B");
    }
}
