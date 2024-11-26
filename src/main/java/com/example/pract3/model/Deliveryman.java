package com.example.pract3.model;

import jakarta.persistence.*;

@Entity
@Table(
        name = "Deliverymans"
)
public class Deliveryman {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String name;
    private String lastname;
    private String middelname;
    private int age;

    @ManyToOne
    @JoinColumn(
            name = "transports_id"
    )
    private Transport transport;
    public Deliveryman(){
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMiddelname() {
        return middelname;
    }

    public void setMiddelname(String middelname) {
        this.middelname = middelname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }
}
