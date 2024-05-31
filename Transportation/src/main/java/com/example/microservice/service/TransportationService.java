package com.example.microservice.service;

import com.example.microservice.entity.Transportation;
import com.example.microservice.exception.NotFoundException;
import com.example.microservice.repository.TransportationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransportationService {

    @Autowired
    private TransportationRepository transportationRepository;

    public void validateTransportation (Long id) {
        Optional<Transportation> transportation = transportationRepository.findById(id);
        if (transportation.isEmpty()){
            throw new NotFoundException(String.format("Tran with ID %s is not exited."));
        }
    }

    public void deleteTransportation(Long id){
        validateTransportation(id);
        transportationRepository.deleteById(id);
    }
    public Transportation findById(Long id){
        validateTransportation(id);
        return transportationRepository.findById(id).orElse(null);
    }

    public List<Transportation> getAll(){
        return transportationRepository.findAll();
    }

    public Transportation save(Transportation transportation){
        return transportationRepository.save(transportation);
    }

    public Transportation update(Long id,Transportation updateTransportation){

        // find by id -> ton tai thi update , k ton tai thi throw ex
        // find ra entity -> set entity = update -> save

        Optional<Transportation> transportation = transportationRepository.findById(id);
        if (transportation.isEmpty()){
            throw new NotFoundException(String.format("Tran with ID %s is not exited.",id));
        }
        Transportation inDb = transportation.get();

        inDb.setTransporter(updateTransportation.getTransporter());
        inDb.setAddress(updateTransportation.getAddress());
        inDb.setTransportRequestNo(updateTransportation.getTransportRequestNo());

        return transportationRepository.save(inDb);
    }
}
