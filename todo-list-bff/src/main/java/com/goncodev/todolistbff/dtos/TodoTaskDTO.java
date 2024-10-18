package com.goncodev.todolistbff.dtos;

import lombok.Builder;

@Builder
public record TodoTaskDTO(Long id, String title,String description) {
}
