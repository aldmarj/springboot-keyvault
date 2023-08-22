package com.example.KeyVault;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.models.KeyVaultSecret;



@RestController
public class KeyVaultController {

  	// Spring Cloud Azure will automatically inject SecretClient in your ApplicationContext.
   private final SecretClient secretClient;

   public KeyVaultController (SecretClient secretClient) {
      this.secretClient = secretClient;
   }

    @GetMapping("/key")
    public String getKeyvaultValue()
   {
      return getStoredValue("KEYNAME");
   }

   private String getStoredValue(String keyName){
      KeyVaultSecret storedSecret = secretClient.getSecret(keyName);
      return storedSecret.getValue();
   }
    
}