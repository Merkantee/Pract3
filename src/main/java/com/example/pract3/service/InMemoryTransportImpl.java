package com.example.pract3.service;

import com.example.pract3.model.Transport;
import com.example.pract3.repository.InMemoryTransportDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InMemoryTransportImpl implements TransportService {
    private final InMemoryTransportDAO transportRepository;

    public InMemoryTransportImpl(InMemoryTransportDAO transportRepository) {
        this.transportRepository = transportRepository;
    }

    @Override
    public List<Transport> findAllTransport() {
        return this.transportRepository.findAllTransport();
    }

    @Override
    public Transport addTransport(Transport transport) {
        return this.transportRepository.addTransport(transport);
    }

    @Override
    public Transport updateTransport(Transport transport) {
        return transportRepository.updateTransport(transport);
    }

    @Override
    public Transport findTransportById(Long id) {
        return transportRepository.findTransportById(id);
    }

    @Override
    public void deleteTransport(Long id) {
        transportRepository.deleteTransport(id);
    }
}
