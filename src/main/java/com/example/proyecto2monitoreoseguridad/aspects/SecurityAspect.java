package com.example.proyecto2monitoreoseguridad.aspects;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityAspect {
    @Before("execution(* com.example.proyecto2monitoreoseguridad.services.*.*(..))")
    public void beforeSecurityMethod() {
        System.out.println("Verificación de seguridad antes de la ejecución del método");
    }
    @After("execution(* com.example.proyecto2monitoreoseguridad.services.*.*(..))")
    public void afterSecurityMethod() {
        System.out.println("Verificación de seguridad después de la ejecución del método");
    }
    @Around("execution(* com.example.proyecto2monitoreoseguridad.services.*.*(..))")
    public Object aroundSecurityMethod(ProceedingJoinPoint joinPoint) throws
            Throwable {
        System.out.println("Inicio de metodo en @Around advice");
        long startTime = System.currentTimeMillis(); // Inicio del cronómetro

        try {
            Object result = joinPoint.proceed();
            long duration = System.currentTimeMillis() - startTime; // Calcula la duración

            System.out.println("Fin de metodo en @Around advice ejecutado en " + duration + "ms");
            return result;
        } catch (Exception e) {
            System.err.println("Error en el método: " + joinPoint.getSignature());
            throw e;
        }
    }

}
