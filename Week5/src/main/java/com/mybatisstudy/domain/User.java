package com.mybatisstudy.domain;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class User {

    private int id;

    @NotEmpty(message = "name must not be null")
    private String name;

//    @Size(max = 100,min=50,message = "the age must be in 50-100")
    @Max(value = 100,message = "the age must be less than 100")
    @Min(value = 50,message = "the age must be greater than 50")
    private int age;
}
