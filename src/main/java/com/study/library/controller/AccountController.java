package com.study.library.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    @GetMapping("/principal")
    public ResponseEntity<?> getPrincipal() {
        System.out.println("test");
        return ResponseEntity.ok(null);
    }
}
