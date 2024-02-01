package com.petr.app.dto;

import lombok.*;
@NoArgsConstructor
@Data
public class Student {
    @NonNull
    private String id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private int age;
}
