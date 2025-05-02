package com.project.hamroschool.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseEntity {
    private String createdby;
    private LocalDateTime createdat;
    private String updatedby;
    private LocalDateTime updatedat;
}
