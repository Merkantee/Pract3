package com.example.pract3.service;

import com.example.pract3.model.Transport;
import com.example.pract3.repository.TransportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportServiceImpl implements TransportService{
    private final TransportRepository repository;

    public TransportServiceImpl(TransportRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Transport> findAllTransport() {
        return this.repository.findAll();
    }

    @Override
    public Transport addTransport(Transport transport) {
        return this.repository.save(transport);
    }

    @Override
    public Transport updateTransport(Transport transport) {
        return this.repository.save(transport);
    }

    @Override
    public Transport findTransportById(Long id) {
        return (Transport) this.repository.findById(id).orElse(null);
    }

    @Override
    public void deleteTransport(Long id) {
        this.repository.deleteById(id);
    }
}
