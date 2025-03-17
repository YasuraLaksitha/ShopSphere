package org.example.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class CategoryPaginationResponseDTO {
    private Integer page;
    private Integer size;
    private String sortBy;
    private String sortDir;
    private boolean isLast;
    private Set<CategoryDTO> contentSet;
}
