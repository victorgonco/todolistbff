package com.goncodev.todolistbff.dtos.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record TodoTaskAddRequest(
        @NotBlank
        String title,
        String description) {
}
