package com.example.proyecto2monitoreoseguridad.services;
import org.springframework.stereotype.Service;



@Service
public class SecurityService {

    public String performTask(String taskName){
        System.out.println("Realizando tarea de seguridad: " + taskName);
        try {
            Thread.sleep(1000); // Simular retraso
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Tarea completada: " + taskName;
    }


}
