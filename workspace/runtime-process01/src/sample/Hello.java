package sample;

public class Hello {
    public static void main(String[] args) {
        final Hello hello = new Hello();
        System.out.println(hello.helloMessage());
        while(true) { }
    }

    private String helloMessage() {
        return "Hello, JVM";
    }
}
