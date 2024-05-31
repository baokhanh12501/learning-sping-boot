package com.example.microservice.dto;

import lombok.Data;

@Data
public class Partner {
    private Long id;
    private String transporterName;
    private int age;
    private String address;
}
