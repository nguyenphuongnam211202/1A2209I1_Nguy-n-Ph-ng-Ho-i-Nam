package com.codegym.exeception;

import jdk.nashorn.internal.ir.RuntimeNode;

public class BookBorrowException extends RuntimeException {
    public BookBorrowException(String message) {
        super(message);
    }
}
