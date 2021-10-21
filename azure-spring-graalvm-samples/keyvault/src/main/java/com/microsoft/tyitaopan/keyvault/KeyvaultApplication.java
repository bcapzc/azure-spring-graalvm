package com.microsoft.tyitaopan.keyvault;

import io.netty.internal.tcnative.SSL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KeyvaultApplication{

    public static void main(String[] args) {
        SpringApplication.run(KeyvaultApplication.class, args);
    }

}
