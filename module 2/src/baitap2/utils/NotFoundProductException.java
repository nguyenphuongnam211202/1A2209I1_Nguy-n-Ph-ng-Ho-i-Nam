package baitap2.utils;

import baitap2.models.Product;

public class NotFoundProductException extends Throwable {
    public NotFoundProductException(String s) {
        super(s);
    }
}
