package package4;

class Main {
    public static void main(String[] args) {

    }
}

class A {
    public void overrideTest() {
        System.out.println("Hello A");
    }
}

//class B extends A { //오버라이딩 불가능
//    public static void overrideTest() {
//        System.out.println("Hello B");
//    }
//}


class D extends A { // 오버라이딩 가능
    public void overrideTest() {
        System.out.println("Hello C");
    }
}