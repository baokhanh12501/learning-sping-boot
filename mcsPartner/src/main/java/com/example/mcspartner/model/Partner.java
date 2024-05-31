package com.example.mcspartner.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "driver")
public class Partner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String transporterName;
    private int age;
    private String address;

    //
}
