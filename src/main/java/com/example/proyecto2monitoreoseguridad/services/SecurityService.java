package com.example.proyecto2monitoreoseguridad.services;
import org.springframework.stereotype.Service;



@Service
public class SecurityService {

    public String performTask(String taskName){
        System.out.println("Realizando tarea de seguridad: " + taskName);
        return "Tarea completada" + taskName;
    }

}
