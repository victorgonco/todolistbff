package com.goncodev.todolistbff.services;

import com.goncodev.todolistbff.dtos.TodoTaskDTO;
import com.goncodev.todolistbff.dtos.mappers.TodoTaskDTOMapper;
import com.goncodev.todolistbff.dtos.request.TodoTaskAddRequest;
import com.goncodev.todolistbff.dtos.request.TodoTaskEditRequest;
import com.goncodev.todolistbff.dtos.response.TodoTasksResponse;
import com.goncodev.todolistbff.repositories.TodoTaskRepository;
import com.goncodev.todolistbff.repositories.entities.TodoTask;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

import static org.apache.commons.lang3.StringUtils.isBlank;

@Slf4j
@Service
public class MainService {

    private final TodoTaskRepository todoTaskRepository;

    public MainService(TodoTaskRepository todoTaskRepository) {
        this.todoTaskRepository = todoTaskRepository;
    }

    @Transactional(readOnly = true)
    public TodoTasksResponse readAll() {
        var todoList = todoTaskRepository.findAll();
        log.info("There are {} tasks.", todoList.size());
        var todoDTOList = todoList.stream().map(TodoTaskDTOMapper::map).toList();
        return TodoTasksResponse.builder()
                .tasks(todoDTOList)
                .build();
    }

    @Transactional
    public void create(TodoTaskAddRequest request){
        todoTaskRepository.save(TodoTask.builder()
                .title(toLowerAndTrim(request.title()))
                .description(toLowerAndTrim(request.description()))
                .build());
    }

    @Transactional
    public void delete(Long id) {
        todoTaskRepository.deleteById(id);
    }

    @Transactional
    public TodoTaskDTO update(Long id, TodoTaskEditRequest editRequest) throws NoSuchElementException {
        var entity = todoTaskRepository.findById(id).orElseThrow();
        entity.setTitle(toLowerAndTrim(editRequest.title()));
        entity.setDescription(toLowerAndTrim(editRequest.description()));
        todoTaskRepository.save(entity);
        return TodoTaskDTOMapper.map(entity);
    }

    private String toLowerAndTrim(String value){
        return isBlank(value) ? null : StringUtils.trimToEmpty(value.toLowerCase());
    }
}
