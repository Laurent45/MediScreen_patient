package com.openclassrooms.mediscreen;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;

@SpringBootApplication
public class MediScreenApplication {

    public static void main(String[] args) {
        SpringApplication.run(MediScreenApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner() {
        return args -> {
            ProcessBuilder builder = new ProcessBuilder();
            File file = new File(System.getProperty("user.home") + "/Dev/OC/MediScreen/src/main/resources/");
            builder.command("sh", "init.sh");
            builder.directory(file);
            builder.start();
        };
    }

}
