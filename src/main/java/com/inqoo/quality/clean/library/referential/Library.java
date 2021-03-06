package com.inqoo.quality.clean.library.referential;

import java.util.List;
import java.util.Set;

public class Library implements BookFacade, ReaderFacade {
    private final ReadersRegister readersRegister;
    private final BookBorrow bookBorrow;
    private final Books books;

    Library(ReadersRegister readersRegister, BookBorrow bookBorrow, Books books) {
        this.readersRegister = readersRegister;
        this.bookBorrow = bookBorrow;
        this.books = books;
    }

    @Override
    public void addBook(Book book) {
        books.addBook(book);
    }

    @Override
    public void addBooks(Book book, int amount) {
        books.addBooks(book, amount);
    }

    @Override
    public int availableCopies(Book book) {
        return books.availableCopies(book);
    }

    @Override
    public Set<Book> bookCatalogue() {
        return books.bookCatalogue();
    }

    @Override
    public void enroll(Reader reader) {
        readersRegister.enroll(reader);
    }

    @Override
    public List<Reader> enrolledReaders() {
        return readersRegister.readers();
    }

    @Override
    public BorrowOutcome borrow(Book book, Reader reader) {
        return bookBorrow.borrow(book, reader);
    }

    @Override
    public ReturnOutcome giveBack(Book book, Reader reader) {
        return bookBorrow.giveBack(book, reader);
    }
}
