package com.example.pract3.service;

import com.example.pract3.model.Deliveryman;

import java.util.List;

public interface DeliverymanService {
    List<Deliveryman> findAllDeliveryman();
    Deliveryman addDeliveryman(Deliveryman deliveryman);
    Deliveryman update(Deliveryman deliveryman);
    Deliveryman findDeliverymanbyId(Long id);
    void deleteDeliveryman(Long id);
}
