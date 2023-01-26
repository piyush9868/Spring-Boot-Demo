package com.noname.springboot.Exceptions;

public class DepartmentNameNotFoundException extends Exception{

    public DepartmentNameNotFoundException(String message){
        super(message);
    }
}
