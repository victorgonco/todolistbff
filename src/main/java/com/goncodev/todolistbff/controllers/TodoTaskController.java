package com.goncodev.todolistbff.controllers;

import com.goncodev.todolistbff.dtos.TodoTaskDTO;
import com.goncodev.todolistbff.dtos.request.TodoTaskAddRequest;
import com.goncodev.todolistbff.dtos.request.TodoTaskEditRequest;
import com.goncodev.todolistbff.dtos.response.TodoTasksResponse;
import com.goncodev.todolistbff.services.MainService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/todo")
@Validated
public class TodoTaskController {

    private final MainService mainService;

    public TodoTaskController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping()
    public TodoTasksResponse findAll() {
        return mainService.readAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@Valid @RequestBody TodoTaskAddRequest request) {
        mainService.create(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        mainService.delete(id);
    }

    @PutMapping("/{id}")
    public TodoTaskDTO update(@PathVariable Long id, @Valid @RequestBody TodoTaskEditRequest editRequest) throws NoSuchElementException {
        return mainService.update(id, editRequest);
    }

}
