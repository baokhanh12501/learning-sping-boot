package com.example.mcspartner.controller;

import com.example.mcspartner.model.Partner;
import com.example.mcspartner.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/partner")
public class PartnerController {
    @Autowired
    private PartnerService partnerService;


    @GetMapping
    public ResponseEntity<List<Partner>> getAllPartners(){

        return new ResponseEntity<>(partnerService.getAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Partner> getPartnerById(@PathVariable Long id){

        return new ResponseEntity<>(partnerService.findById(id),HttpStatus.OK);
    }

    @PostMapping("/{create}")
    public ResponseEntity<Partner> createPartner(@RequestBody Partner partner){

        return new ResponseEntity<>(partnerService.save(partner),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Partner> updatePartner(@PathVariable Long id, @RequestBody Partner updatePartner){

        return new ResponseEntity<>(partnerService.update(id, updatePartner),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePartner(@PathVariable Long id){
        partnerService.deletePartner(id);


        return new ResponseEntity<>(HttpStatus.OK);
    }
}
