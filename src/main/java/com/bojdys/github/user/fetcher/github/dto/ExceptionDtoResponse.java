package com.bojdys.github.user.fetcher.github.dto;

public class ExceptionDtoResponse {

    private int status;
    private String message;

    public ExceptionDtoResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

}
