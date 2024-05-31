package com.example.microservice.feign;


import com.example.microservice.dto.Partner;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "partner-service", url = "http://localhost:8081/partner")
public interface PartnerClient {

    @GetMapping
    List<Partner> getAllPartners();

    @GetMapping("/{id}")
    Partner getPartnerById(@PathVariable Long id);

}
