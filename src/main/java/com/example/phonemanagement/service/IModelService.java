package com.example.phonemanagement.service;

import com.example.phonemanagement.model.Model;

import java.util.Optional;

public interface IModelService {
    Iterable<Model> findAll();

    Optional<Model> findById(Long id);

    Model save(Model model);

    void remove(Long id);
}
