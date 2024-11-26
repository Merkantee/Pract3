package com.example.pract3.service;

import com.example.pract3.model.Transport;

import java.util.List;

public interface TransportService {
    List<Transport> findAllTransport();
    Transport addTransport(Transport transport);
    Transport updateTransport(Transport transport);
    Transport findTransportById(Long id);
    void deleteTransport(Long id);

}
