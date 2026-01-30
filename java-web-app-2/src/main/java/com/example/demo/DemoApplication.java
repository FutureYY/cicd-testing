package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    // Example 1: Long method with many branches
    @RequestMapping("/status")
    public String checkStatus(int code) {
        if (code == 1) {
            return "Status: OK";
        } else if (code == 2) {
            return "Status: WARNING";
        } else if (code == 3) {
            return "Status: CRITICAL";
        } else if (code == 4) {
            return "Status: UNKNOWN";
        } else if (code == 5) {
            return "Status: NOT APPLICABLE";
        } else if (code == 6) {
            return "Status: PENDING";
        } else if (code == 7) {
            return "Status: IN PROGRESS";
        } else if (code == 8) {
            return "Status: COMPLETED";
        } else if (code == 9) {
            return "Status: FAILED";
        } else {
            return "Status: DEFAULT";
        }
    }

    // Example 2: Hard-coded strings repeated
    @RequestMapping("/")
    public String home() {
        return "Hello Docker World!";
    }

    @RequestMapping("/greet")
    public String greet() {
        return "Hello Docker World!";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "Hello Docker World!";
    }
}
