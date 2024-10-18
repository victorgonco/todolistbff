package com.goncodev.todolistbff.dtos.mappers;

import com.goncodev.todolistbff.dtos.TodoTaskDTO;
import com.goncodev.todolistbff.repositories.entities.TodoTask;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TodoTaskDTOMapper {
    public static TodoTaskDTO map(TodoTask entity) {
        return TodoTaskDTO.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .build();
    }

}
