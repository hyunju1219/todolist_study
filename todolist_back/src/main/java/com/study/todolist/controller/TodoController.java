package com.study.todolist.controller;

import com.study.todolist.dto.request.todo.ReqAddTodoDto;
import com.study.todolist.dto.response.todo.RespTodoDto;
import com.study.todolist.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping("/todo")
    public ResponseEntity<?> add(@RequestBody ReqAddTodoDto dto) {
        int successCount = todoService.addTodo(dto);
        return ResponseEntity.created(null).body(successCount);
    }

    @GetMapping("/todolist")
    public ResponseEntity<?> getAll() {
        List<RespTodoDto> list = todoService.getTodoList();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/todo/counts")
    public ResponseEntity<?> getCounts() {
        return ResponseEntity.ok().body(todoService.getTodoCounts());
    }
}