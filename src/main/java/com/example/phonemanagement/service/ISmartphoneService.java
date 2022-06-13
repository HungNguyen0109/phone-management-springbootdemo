package com.example.phonemanagement.service;

import com.example.phonemanagement.model.Model;
import com.example.phonemanagement.model.Smartphone;

import java.util.List;
import java.util.Optional;

public interface ISmartphoneService {
    Iterable<Smartphone> findAll();

    Optional<Smartphone> findById(Long id);

    Smartphone save(Smartphone smartPhone);

    void remove(Long id);
    Iterable<Smartphone> findAllByProducerContaining(String producer);
    Iterable<Smartphone> findAllByOrderByPrice();
    List<Smartphone> findAllByPriceBetween(Double from, Double to);
    Iterable<Smartphone> getTop4New();
    Iterable<Smartphone> findAllByModel(Model model);


}
