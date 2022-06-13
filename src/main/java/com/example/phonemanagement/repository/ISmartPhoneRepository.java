package com.example.phonemanagement.repository;

import com.example.phonemanagement.model.Model;
import com.example.phonemanagement.model.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISmartPhoneRepository extends JpaRepository<Smartphone,Long> {
    Iterable<Smartphone> findAllByProducerContaining(String producer);
    Iterable<Smartphone> findAllByOrderByPrice();
    Iterable<Smartphone> findAllByModel(Model model);
    List<Smartphone> findAllByPriceBetween(Double from, Double to);

    @Query(value = "select * from smartphones order by id desc limit 4 ", nativeQuery = true)
    Iterable<Smartphone> findTop4New();
}
