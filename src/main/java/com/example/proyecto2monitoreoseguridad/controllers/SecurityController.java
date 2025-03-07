package com.example.proyecto2monitoreoseguridad.controllers;
import com.example.proyecto2monitoreoseguridad.services.SecurityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class SecurityController {

    @Autowired
    private SecurityService securityService;


    @GetMapping("/perform")
    public String performTask(@RequestParam String task){
        if (task == null || task.isEmpty()) {
            throw new IllegalArgumentException("El parámetro 'task' no puede estar vacío");
        }
        return securityService.performTask(task);
    }
    @GetMapping("/secure")
    public String secureEndpoint(@RequestParam String data) {
        return "Secured data: " + data;
    }

}
