package com.example.proyecto2monitoreoseguridad;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AspectTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAspectExecution() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/perform?task=aspectTest"))
                .andExpect(status().isOk());
    }
    @Test
    public void testConcurrentRequests() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                try {
                    mockMvc.perform(MockMvcRequestBuilders.get("/perform?task=concurrentTest"))
                            .andExpect(status().isOk());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
    }

}
