package com.example.pract3.service;

import com.example.pract3.model.Deliveryman;
import com.example.pract3.repository.DeliverymanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliverymanServiceImpl implements DeliverymanService{
    private DeliverymanRepository deliverymanRepository;

    public DeliverymanServiceImpl(DeliverymanRepository deliverymanRepository) {
        this.deliverymanRepository = deliverymanRepository;
    }

    @Override
    public List<Deliveryman> findAllDeliveryman() {
        return this.deliverymanRepository.findAll();
    }

    @Override
    public Deliveryman addDeliveryman(Deliveryman deliveryman) {
        return (Deliveryman) this.deliverymanRepository.save(deliveryman);
    }

    @Override
    public Deliveryman update(Deliveryman deliveryman) {
        return (Deliveryman) this.deliverymanRepository.save(deliveryman);
    }

    @Override
    public Deliveryman findDeliverymanbyId(Long id) {
        return (Deliveryman) this.deliverymanRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteDeliveryman(Long id) {
        this.deliverymanRepository.deleteById(id);
    }
}
