package me.youngsil;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookServiceTest {


    BookService bookServie = new BookServiceProxy(new DefaultBookService());

    @Test
    public void di() {
        Book book = new Book();
        book.setTitle("spring");
        bookServie.rent(book);
    }
}