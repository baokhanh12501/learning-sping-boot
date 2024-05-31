package com.example.microservice.dto;

import lombok.Data;

@Data
public class TransportationDto {
    private Long id;
    private String transportRequestNo;
    private Partner transporter;
    private String address;
}
