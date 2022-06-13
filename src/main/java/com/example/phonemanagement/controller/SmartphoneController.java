package com.example.phonemanagement.controller;

import com.example.phonemanagement.model.Model;
import com.example.phonemanagement.model.Smartphone;
import com.example.phonemanagement.service.IModelService;
import com.example.phonemanagement.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/smartphones")
public class SmartphoneController {
    @Autowired
    private ISmartphoneService smartphoneService;
    @Autowired
    private IModelService modelService;
    @ModelAttribute("model")
    public Iterable<Model> models(){
        return modelService.findAll();
    }
    @GetMapping
    public ResponseEntity<?> showlist() {
        List<Smartphone> smartphones = (List<Smartphone>) smartphoneService.findAll();
        if (smartphones.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(smartphones, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Smartphone> createNewPhone(@RequestBody Smartphone smartphone) {
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findSmartphoneById(@PathVariable long id) {
        Optional<Smartphone> smartphoneOptional = smartphoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.OK);
    }

    @GetMapping("/find-by-producer")
    public ResponseEntity<?> findSmartphoneByProducer(@RequestBody String producer) {
        List<Smartphone> smartphones = (List<Smartphone>) smartphoneService.findAllByProducerContaining(producer);
        if (smartphones.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(smartphones, HttpStatus.OK);
    }

    @GetMapping("/sort-by-price")
    public ResponseEntity<?> sortSmartphoneByPrice() {
        List<Smartphone> smartphones = (List<Smartphone>) smartphoneService.findAllByOrderByPrice();
        if (smartphones.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(smartphones, HttpStatus.OK);
    }

    @GetMapping("/price-between")
    public ResponseEntity<?> sortSmartphoneByPriceBetween(@RequestParam Double from, @RequestParam Double to) {
        List<Smartphone> smartphones = smartphoneService.findAllByPriceBetween(from, to);
        if (smartphones.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(smartphones, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateSmartphone(@PathVariable long id, @RequestBody Smartphone smartphone) {
        Optional<Smartphone> smartphoneOptional = smartphoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphone.setId(smartphoneOptional.get().getId());
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteSmartphone(@PathVariable long id) {
        Optional<Smartphone> smartphoneOptional = smartphoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneService.remove(id);
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/find-top-4")
    public ResponseEntity<?> findTopNew() {
        List<Smartphone> smartphones = (List<Smartphone>) smartphoneService.getTop4New();
        if (smartphones.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(smartphones, HttpStatus.OK);
    }
}
