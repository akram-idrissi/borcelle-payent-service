package org.microservice.paymentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private AuthServiceClient authServiceClient;

    @PostMapping("")
    public ResponseEntity<?> checkToken(@RequestHeader("Authorization") String authorizationHeader) {
        try {
            System.out.println(token);
            ResponseEntity<?> response = authServiceClient.validateToken(token);
            return ResponseEntity.ok(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token validation failed: " + e.getMessage());
        }
    }
}

