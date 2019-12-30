package me.youngsil;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static org.junit.Assert.*;

public class BookServiceTest {

    BookService bookService = (BookService) Proxy.newProxyInstance(BookService.class.getClassLoader(), new Class[]{BookService.class},
            new InvocationHandler() {
                BookService bookService = new DefaultBookService();

                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if(method.getName().equals("rent")){
                        System.out.println("aaa");
                        Object invoke = method.invoke(bookService, args);
                        System.out.println("bbb");
                        return invoke;
                    }
                    return method.invoke(bookService, args);
                }
            });

    @Test
    public void di() {
        Book book = new Book();
        book.setTitle("spring");
        bookService.rent(book);
        bookService.returnBook();
    }
}