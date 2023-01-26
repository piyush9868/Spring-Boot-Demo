package com.noname.springboot.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Entity
@Getter @Setter @RequiredArgsConstructor @ToString
//
public class Department {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long departmentId;

    @NotNull(message = "Please enter name. Its a required field")
    private String departmentName;

    @Length(max = 40)
    private String departmentAddress;
    private String departmentCode;


}
