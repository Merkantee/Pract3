package com.example.pract3.controller;

import com.example.pract3.model.Deliveryman;
import com.example.pract3.model.Transport;
import com.example.pract3.service.DeliverymanService;
import com.example.pract3.service.TransportService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TransportControler {
    @Qualifier("transportServiceImpl")
    @Autowired
    private TransportService transportService;
    @Autowired
    private DeliverymanService deliverymanService;

    public TransportControler(){
    }

    @GetMapping({"/transport"})
    public String getAllTransport(Model model) {
        List<Transport> students = this.transportService.findAllTransport();
        List<Deliveryman> marks = this.deliverymanService.findAllDeliveryman();
        model.addAttribute("students", students);
        model.addAttribute("marks", marks);
        model.addAttribute("student", new Transport());
        return "transports";
    }

    @PostMapping({"/transport"})
    public String addTransport(@ModelAttribute @Valid Transport student, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<Transport> students = this.transportService.findAllTransport();
            List<Deliveryman> marks = this.deliverymanService.findAllDeliveryman();
            model.addAttribute("students", students);
            model.addAttribute("marks", marks);
            model.addAttribute("student", new Transport());
            return "transports";
        } else {
            this.transportService.addTransport(student);
            return "redirect:/transports";
        }
    }

    @GetMapping({"/transport/edit/{id}"})
    public String editStudent(@PathVariable Long id, Model model) {
        Transport student = this.transportService.findTransportById(id);
        model.addAttribute("student", student);
        return "editTransports";
    }

    @PostMapping({"/transport/update"})
    public String updateStudent(@ModelAttribute @Valid Transport student, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            System.out.println("Validation errors: " + String.valueOf(bindingResult.getAllErrors()));
            List<Transport> students = this.transportService.findAllTransport();
            model.addAttribute("students", students);
            model.addAttribute("student", student);
            return "transports";
        } else {
            this.transportService.updateTransport(student);
            return "redirect:/transports";
        }
    }

    @GetMapping({"/transport/delete/{id}"})
    public String deleteStudent(@PathVariable Long id) {
        this.transportService.deleteTransport(id);
        return "redirect:/transports";
    }
}
