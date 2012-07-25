package com.common;

public class SignoffException extends RuntimeException{

    public SignoffException()
    {
       super();
    }

    public SignoffException(String reason)
    {
        super(reason);
    }
}
