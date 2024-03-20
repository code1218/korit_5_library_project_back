package com.study.library.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mail")
public class AccountMailController {

    @PostMapping("/send")
    @ResponseBody
    public ResponseEntity<?> send() {

        return ResponseEntity.ok(null);
    }
}
