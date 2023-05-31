package com.app;

import com.app.model.Inventory;
import com.app.repo.InventoryRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class InventoryApp {

    @Bean
    public CommandLineRunner loadData(InventoryRepo inventoryRepo){
        return args -> {
            Inventory inventory = new Inventory();
            inventory.setSkuCode("iphone 13");
            inventory.setQuantity(100);

            Inventory inventory1 = new Inventory();
            inventory1.setSkuCode("iphone 12");
            inventory1.setQuantity(0);

            inventoryRepo.save(inventory);
            inventoryRepo.save(inventory1);
        };
    }
    public static void main(String[] args) {
        SpringApplication.run(InventoryApp.class, args);
    }
}