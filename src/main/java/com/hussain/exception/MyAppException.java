package com.hussain.exception;

import org.springframework.http.HttpStatus;

import com.hussain.enums.LoanApplicationResponseCode;

public class MyAppException extends RuntimeException {

    public int code;
    public String message;
    public HttpStatus httpStatus;

    public MyAppException(String msg) {
        super(msg);
    }

    public MyAppException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.code = httpStatus.value();
        this.httpStatus = httpStatus;
    }

    public MyAppException(LoanApplicationResponseCode personNotFound, HttpStatus httpStatus) {
        this.code = httpStatus.value();
        this.httpStatus = httpStatus;
        this.message = personNotFound.getMessage();

    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public int getCode() {
        return code;
    }

}
