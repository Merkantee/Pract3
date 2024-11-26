package com.example.pract3.repository;

import com.example.pract3.model.Deliveryman;
import com.example.pract3.model.Transport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryDeliveryman {
    private final List<Deliveryman> LISTdeliveryman = new ArrayList<>();
    public InMemoryDeliveryman(){

    }
    public List<Deliveryman> findAllDeliveryman(Long id){
        return this.LISTdeliveryman;
    }

    public Deliveryman addDeliveryman(Deliveryman deliveryman){
        this.LISTdeliveryman.add(deliveryman);
        return deliveryman;
    }
    public Deliveryman updateDeliveryman(Deliveryman deliveryman){
        int transportIndex = IntStream.range(0, this.LISTdeliveryman.size()).filter((index) -> {
            return ((Deliveryman)this.LISTdeliveryman.get(index)).getId().equals(deliveryman.getId());
        }).findFirst().orElse(-1);
        if (transportIndex == -1){
            return null;
        } else {
            this.LISTdeliveryman.set(transportIndex, deliveryman);
            return deliveryman;
        }
    }

    public void deleteDeliveryman(Long id){
        List<Deliveryman> transport = this.findAllDeliveryman(id);
        if (transport != null){
            this.LISTdeliveryman.remove(transport);
        }
    }
}
