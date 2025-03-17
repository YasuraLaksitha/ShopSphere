package org.example.entity;


public class NoResourceFoundException extends RuntimeException {
    private String resourceName;
    private String fieldName;
    private String filed;
    private String fieldId;

    public NoResourceFoundException(String resourceName, String fieldName, String filed) {
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.filed = filed;
    }
}
