package study;


import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Application {

    public static void main(String[] args) {

        Repository repository = new Repository();
        Service service = new Service();

        Class<? extends Service> aClass = service.getClass();

        Arrays.stream(aClass.getDeclaredFields()).forEach(f -> {
            if(f.getAnnotation(Inject.class) != null) {
                f.setAccessible(true);
                try {
                    f.set(service, repository);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println("service = " + service.getRepository());

    }
}
