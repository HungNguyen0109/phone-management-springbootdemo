package com.example.phonemanagement.service;

import com.example.phonemanagement.model.Model;
import com.example.phonemanagement.repository.IModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ModelService implements IModelService {
    @Autowired
    private IModelRepository modelRepository;
    @Override
    public Iterable<Model> findAll() {
        return modelRepository.findAll();
    }

    @Override
    public Optional<Model> findById(Long id) {
        return modelRepository.findById(id);
    }

    @Override
    public Model save(Model model) {
        return modelRepository.save(model);
    }

    @Override
    public void remove(Long id) {
        modelRepository.deleteById(id);
    }
}
