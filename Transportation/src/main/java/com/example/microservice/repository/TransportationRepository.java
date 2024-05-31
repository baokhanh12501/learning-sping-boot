package com.example.microservice.repository;

import com.example.microservice.entity.Transportation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportationRepository extends JpaRepository<Transportation, Long> {
    Transportation getByTransportRequestNo(String rqNo);

}
