package com.example.day5_week4.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@RequiredArgsConstructor
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Coffee name must not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @NotEmpty
    @Column(columnDefinition = "varchar(20) not null, check(category = 'drink' or category = 'sweet')")
    private String category;

    @NotNull
    private Double price;

}
