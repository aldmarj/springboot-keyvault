package com.example.KeyVault;

import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecretClientConfiguration {

    @Bean
    public SecretClient createSecretClient() {
        return new SecretClientBuilder()
            .vaultUrl("https://<YOUR_KEYVAULT>.vault.azure.net/")
            .credential(new DefaultAzureCredentialBuilder().build())
            .buildClient();
    }

}
