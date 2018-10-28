package com.sagarandcompany.mongodemo.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Employee {
    @Id
    private String id;
    private String name;
    private String email;
    private Integer age;
}
