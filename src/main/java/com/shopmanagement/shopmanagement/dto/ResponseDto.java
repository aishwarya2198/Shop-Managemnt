package com.shopmanagement.shopmanagement.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class ResponseDto implements Serializable {

    private boolean success;
    private String errorMessage;
    private String message;
    private Serializable body;

    public <T> ResponseDto(boolean success, String message, T body) {
        this.success = success;
        this.message = message;
        this.body = new ArrayList<T>();
        ((ArrayList) this.body).add(body);
    }

    public ResponseDto(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public <T> ResponseDto(boolean success, Serializable body) {
        this.success = success;
        this.body = new ArrayList<T>();
        ((ArrayList) this.body).add(body);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Serializable getBody() {
        return body;
    }

    public void setBody(Serializable body) {
        this.body = body;
    }
}
