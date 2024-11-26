package com.example.pract3.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(
        name = "Transports"
)
public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    private String name;
    private int price;
    private String number;

    @OneToMany(
            mappedBy = "Transports",
            fetch = FetchType.EAGER
    )
    private Collection<Deliveryman> deliveryman;
    public Transport() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Collection<Deliveryman> getDeliveryman() {
        return deliveryman;
    }

    public void setDeliveryman(Collection<Deliveryman> deliveryman) {
        this.deliveryman = deliveryman;
    }
}
