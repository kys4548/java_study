package me.youngsil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class DefaultBookService implements BookService {

    @Override
    public void rent(Book book) {
        System.out.println("rent: " + book.getTitle());
    }
}
