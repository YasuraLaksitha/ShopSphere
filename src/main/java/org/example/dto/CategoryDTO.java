package org.example.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CategoryDTO {

    @NotBlank
    @Size(min = 5, message = "Category name must me at least 5 chars")
    private String name;
}
