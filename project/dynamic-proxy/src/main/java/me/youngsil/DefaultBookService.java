package me.youngsil;

public class DefaultBookService implements BookService {

    @Override
    public void rent(Book book) {
        System.out.println("rent: " + book.getTitle());
    }

    @Override
    public void returnBook() {

    }
}
