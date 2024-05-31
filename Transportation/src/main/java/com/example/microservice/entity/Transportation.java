package com.example.microservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "transportRequest")
public class Transportation{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String transportRequestNo;
    private int transporter; //partner ID
    private String address;

    //
}
