package study;

import java.lang.reflect.ReflectPermission;

public class Service {

    @Inject
    private Repository repository;

    public Repository getRepository() {
        return repository;
    }
}
