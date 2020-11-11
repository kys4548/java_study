package package2;

public class C extends B{

}

class B {
    public void publicHello() {
        System.out.println("public B");
    }

    protected void protectedHello() {
        System.out.println("protected B");
    }

    void defaultHello() {
        System.out.println("default B");
    }

    private void privateHello() {
        System.out.println("private B");
    }
}
