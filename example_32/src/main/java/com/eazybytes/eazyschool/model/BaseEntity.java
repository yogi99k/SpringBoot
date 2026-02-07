package com.eazybytes.eazyschool.model;

import lombok.Data;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@Data
public class BaseEntity {
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
}
