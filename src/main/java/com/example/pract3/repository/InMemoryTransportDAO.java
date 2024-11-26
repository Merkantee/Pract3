package com.example.pract3.repository;

import com.example.pract3.model.Transport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryTransportDAO {
    private final List<Transport> TRANSPORT = new ArrayList<>();
    public InMemoryTransportDAO(){

    }
    public List<Transport> findAllTransport(){return this.TRANSPORT;}

    public Transport addTransport(Transport transport){
        this.TRANSPORT.add(transport);
        return transport;
    }
    public Transport updateTransport(Transport transport){
        int transportIndex = IntStream.range(0, this.TRANSPORT.size()).filter((index) ->{
            return ((Transport)this.TRANSPORT.get(index)).getId().equals(transport.getId());
        }).findFirst().orElse(-1);
        if (transportIndex == -1){
            return null;
        } else {
            this.TRANSPORT.set(transportIndex, transport);
            return transport;
        }
    }
    public Transport findTransportById(Long id) {
        return (Transport) this.TRANSPORT.stream().filter((element) -> {
            return element.getId().equals(id);
        }).findFirst().orElse(null);
    }
    public void deleteTransport(Long id){
        Transport transport = this.findTransportById(id);
        if (transport != null){
            this.TRANSPORT.remove(transport);
        }
    }
}
