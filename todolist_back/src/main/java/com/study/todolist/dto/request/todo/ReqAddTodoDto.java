package com.study.todolist.dto.request.todo;

import com.study.todolist.entity.Todo;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Builder
@Data
public class ReqAddTodoDto {
    private String title;
    private String content;
    private String dateTime;
    private int important;
    private int busy;

    public Todo toEntity() {
        //string -> LocalDateTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime todoDateTime = LocalDateTime.parse(dateTime + ":00", formatter);

        return Todo.builder()
                .title(title)
                .content(content)
                .todoDateTime(todoDateTime)
                .important(important)
                .busy(busy)
                .build();
    }
}
