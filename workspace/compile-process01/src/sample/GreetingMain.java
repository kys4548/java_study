package sample;

import java.lang.reflect.InvocationTargetException;

public class GreetingMain {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        KoreanGreeting koreanGreeting = new KoreanGreeting();
        System.out.println(koreanGreeting.sayHello("test!!"));

        Greeting greeting = new KoreanGreeting();
        System.out.println(greeting.sayHello("test!!!"));

        sayHelloDynamicallyLoadedClass(args[0]);
    }

    private static void sayHelloDynamicallyLoadedClass(String arg) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        ClassLoader classLoader = GreetingMain.class.getClassLoader();
        Class<?> aClass = classLoader.loadClass(arg);
        if(Greeting.class.isAssignableFrom(aClass)) {
            Greeting aGreeting = (Greeting) aClass.getDeclaredConstructor().newInstance();
            System.out.println(aGreeting.sayHello("test!!!!"));
        }
    }
}
