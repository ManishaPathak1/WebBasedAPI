package com.example.webbasedspringapi.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "userStudent")
public class Student {

    @Id
    @GeneratedValue
    private int id;


    private String userName;

    private String userAddress;

    private String password;


}
