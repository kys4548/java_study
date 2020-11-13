package sample;

public class KoreanGreeting extends Object implements Greeting {
    private String hello = "안녕";

    @Override
    public String sayHello(String name) {
        return getHello() + name;
    }

    private String getHello() {
        return this.hello;
    }
}
