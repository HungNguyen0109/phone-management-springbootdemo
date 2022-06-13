package com.example.phonemanagement.controller;

import com.example.phonemanagement.model.Model;
import com.example.phonemanagement.model.Smartphone;
import com.example.phonemanagement.service.IModelService;
import com.example.phonemanagement.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.Optional;

@Controller
@RequestMapping("/models")
public class ModelController {
    @Autowired
    private IModelService modelService;
    @Autowired
    private ISmartphoneService smartphoneService;
    @GetMapping("/{id}/smartphones")
    public ResponseEntity<?> findProductsByCategory(@PathVariable Long id) {
        Optional<Model> modelOptional = modelService.findById(id);
        Iterable<Smartphone> smartphones = smartphoneService.findAllByModel(modelOptional.get());
        return new ResponseEntity<>(smartphones, HttpStatus.OK);
    }
}
