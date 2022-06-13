package com.example.phonemanagement.repository;

import com.example.phonemanagement.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IModelRepository extends JpaRepository<Model,Long> {
}
