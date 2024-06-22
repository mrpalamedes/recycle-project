package com.project.demo.exception;

public class ProductNotExistException extends IllegalArgumentException {
    public ProductNotExistException(String msg){
        super(msg);
    }
}
