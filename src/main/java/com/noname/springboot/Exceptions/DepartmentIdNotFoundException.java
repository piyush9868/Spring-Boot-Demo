package com.noname.springboot.Exceptions;

public class DepartmentIdNotFoundException extends Exception{

    public DepartmentIdNotFoundException(String message){
        super(message);
    }
}
