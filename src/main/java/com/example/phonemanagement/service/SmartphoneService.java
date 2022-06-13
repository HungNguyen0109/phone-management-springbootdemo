package com.example.phonemanagement.service;

import com.example.phonemanagement.model.Model;
import com.example.phonemanagement.model.Smartphone;
import com.example.phonemanagement.repository.ISmartPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SmartphoneService implements ISmartphoneService{
    @Autowired
    private ISmartPhoneRepository smartPhoneRepository;
    @Override
    public Iterable<Smartphone> findAll() {
        return smartPhoneRepository.findAll();
    }

    @Override
    public Optional<Smartphone> findById(Long id) {
        return smartPhoneRepository.findById(id);
    }

    @Override
    public Smartphone save(Smartphone smartPhone) {
        return smartPhoneRepository.save(smartPhone);
    }

    @Override
    public void remove(Long id) {
        smartPhoneRepository.deleteById(id);
    }

    @Override
    public Iterable<Smartphone> findAllByProducerContaining(String producer) {
        return smartPhoneRepository.findAllByProducerContaining(producer);
    }

    @Override
    public Iterable<Smartphone> findAllByOrderByPrice() {
        return smartPhoneRepository.findAllByOrderByPrice();
    }

    @Override
    public List<Smartphone> findAllByPriceBetween(Double from, Double to) {
        return smartPhoneRepository.findAllByPriceBetween(from,to);
    }

    @Override
    public Iterable<Smartphone> getTop4New() {
        return smartPhoneRepository.findTop4New();
    }

    @Override
    public Iterable<Smartphone> findAllByModel(Model model) {
        return smartPhoneRepository.findAllByModel(model);

    }


}
