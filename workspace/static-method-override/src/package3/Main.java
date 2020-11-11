//package package3;
//
//class Main {
//    public static void main(String[] args) {
//        A.overrideTest();
//        B.overrideTest();
//    }
//}
//
//class A { // static method
//    public static void overrideTest() {
//        System.out.println("Hello A");
//    }
//}
//
//class B extends A { //오버라이딩 불가능
//    public static void overrideTest() {
//        System.out.println("Hello B");
//    }
//}
//
//class D extends A { // 오버라이딩 불가능
//    public void overrideTest() {
//        System.out.println("Hello C");
//    }
//}