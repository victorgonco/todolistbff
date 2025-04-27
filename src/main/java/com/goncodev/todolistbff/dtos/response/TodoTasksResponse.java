package com.goncodev.todolistbff.dtos.response;

import com.goncodev.todolistbff.dtos.TodoTaskDTO;
import lombok.Builder;

import java.util.List;

@Builder
public record TodoTasksResponse (List<TodoTaskDTO> tasks){}
