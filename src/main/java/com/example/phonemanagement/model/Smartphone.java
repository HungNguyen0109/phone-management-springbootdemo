package com.example.phonemanagement.model;

import javax.persistence.*;

@Entity
@Table(name="smartphones")
public class Smartphone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String producer;
    @ManyToOne
    @JoinColumn
    private Model model;
    private double price;

    public Smartphone() {
    }

    public Smartphone(String producer, Model model, double price) {
        this.producer = producer;
        this.model = model;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return producer+": "+model+" with price "+price;
    }

}
