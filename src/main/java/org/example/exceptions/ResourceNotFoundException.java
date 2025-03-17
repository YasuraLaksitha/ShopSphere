package org.example.exceptions;

public class ResourceNotFoundException extends RuntimeException {
     String resourceName;
     String fieldName;
     String filed;

    public ResourceNotFoundException(String resourceName, String fieldName, String filed) {
        super(String.format("%s not found with %s: %s",resourceName,filed,fieldName));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.filed = filed;
    }

}
