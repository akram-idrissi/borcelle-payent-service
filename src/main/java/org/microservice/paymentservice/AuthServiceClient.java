package org.microservice.paymentservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(name = "auth-service")
public interface AuthServiceClient {

    @PostMapping("/token/validate")
    ResponseEntity<?> validateToken(RequestHeader("Authorization") String token);
    //ResponseEntity<Map<String, Object>> validateToken(@RequestBody Map<String, String> request);
}
