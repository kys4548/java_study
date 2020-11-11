package package5;

public class Main {
    public static void main(String[] args) {
        B.test();
    }
}

class A {
    public static void test() {
        System.out.println("Hello A");
    }
}

class B extends A {

}
