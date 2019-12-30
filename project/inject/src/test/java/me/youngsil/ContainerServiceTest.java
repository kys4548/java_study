package me.youngsil;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContainerServiceTest {

    @Test
    public void getObject_BookRepository() {
        BookService bookService = ContainerService.getObject(BookService.class);
        assertNotNull(bookService);
        assertNotNull(bookService.bookRepository);
    }
}