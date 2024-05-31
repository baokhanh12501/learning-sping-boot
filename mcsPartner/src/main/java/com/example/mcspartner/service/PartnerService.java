package com.example.mcspartner.service;

import com.example.mcspartner.exception.NotFoundException;
import com.example.mcspartner.model.Partner;
import com.example.mcspartner.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartnerService {

    @Autowired
    private PartnerRepository partnerRepository;

    public void validatePartner(Long id) {
        Optional<Partner> partner = partnerRepository.findById(id);
        if (partner.isEmpty()) {
            throw new NotFoundException(String.format("Tran with ID %s is not exited.", id));
        }
    }

    public void deletePartner(Long id) {
        validatePartner(id);
        partnerRepository.deleteById(id);
    }

    public Partner findById(Long id) {
        validatePartner(id);
        return partnerRepository.findById(id).orElse(null);
    }

    public List<Partner> getAll() {
        return partnerRepository.findAll();
    }

    public Partner save(Partner partner) {
        return partnerRepository.save(partner);
    }

    public Partner update(Long id, Partner updatePartner) {

        // find by id -> ton tai thi update , k ton tai thi throw ex
        // find ra entity -> set entity = update -> save

        Optional<Partner> partner = partnerRepository.findById(id);
        if (partner.isEmpty()) {
            throw new NotFoundException(String.format("Tran with ID %s is not exited.", id));
        }
        Partner inDb = partner.get();

        inDb.setTransporterName(updatePartner.getTransporterName());
        inDb.setAddress(updatePartner.getAddress());
        inDb.setAge(updatePartner.getAge());

        return partnerRepository.save(inDb);
    }

}
