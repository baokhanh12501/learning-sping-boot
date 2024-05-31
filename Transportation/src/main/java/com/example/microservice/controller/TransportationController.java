package com.example.microservice.controller;

import com.example.microservice.dto.Partner;
import com.example.microservice.dto.TransportationDto;
import com.example.microservice.entity.Transportation;
import com.example.microservice.feign.PartnerClient;
import com.example.microservice.service.TransportationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/transportations")
public class TransportationController {


    private final TransportationService transportationService;


    private final PartnerClient partnerClient;

    public TransportationController(TransportationService transportationService, PartnerClient partnerClient) {
        this.transportationService = transportationService;
        this.partnerClient = partnerClient;
    }

    @GetMapping
    public ResponseEntity<List<Transportation>> getAllTransportations() {
        return new ResponseEntity<>(transportationService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransportationDto> getTransportationById(@PathVariable Long id) {
        Transportation transportation = transportationService.findById(id);
        Long partnerId = (long) transportation.getTransporter();
        Partner partnerById = partnerClient.getPartnerById(partnerId);
        TransportationDto dto = new TransportationDto();
        dto.setTransporter(partnerById);
        dto.setTransportRequestNo(transportation.getTransportRequestNo());
        dto.setId(transportation.getId());
        dto.setAddress(transportation.getAddress());

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Transportation> createTransportation(@RequestBody Transportation transportation) {
        return new ResponseEntity<>(transportationService.save(transportation), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transportation> updateTransportation(@PathVariable Long id, @RequestBody Transportation updatedTransportation) {
        return new ResponseEntity<>(transportationService.update(id, updatedTransportation), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransportation(@PathVariable Long id) {
        transportationService.deleteTransportation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
