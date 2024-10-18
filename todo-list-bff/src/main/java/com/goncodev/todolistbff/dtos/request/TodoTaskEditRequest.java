package com.goncodev.todolistbff.dtos.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record TodoTaskEditRequest(
        @NotBlank
        String title,
        String description) {
}
