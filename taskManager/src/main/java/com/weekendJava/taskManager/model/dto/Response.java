package com.weekendJava.taskManager.model.dto;


import lombok.Data;

@Data
public class Response {
    private Boolean success;
    private String message;
    private Object data;
}
