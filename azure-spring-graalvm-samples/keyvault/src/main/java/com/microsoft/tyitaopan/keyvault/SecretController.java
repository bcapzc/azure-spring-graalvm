package com.microsoft.tyitaopan.keyvault;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecretController {

    @Value("${test-secret-name}")
    private String testSecret;

    @GetMapping("/getsecret")
    public String getSecret() {
        System.out.println(testSecret);
        return testSecret;
    }
}
