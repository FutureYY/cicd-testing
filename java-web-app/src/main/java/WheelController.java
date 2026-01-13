package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class WheelController {

    private final WheelService wheelService;

    public WheelController(WheelService wheelService) {
        this.wheelService = wheelService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("result", "");
        return "index";
    }

    @PostMapping("/spin")
    public String spin(@RequestParam("options") String optionsInput, Model model) {
        List<String> options = Arrays.asList(optionsInput.split(","));
        String result = wheelService.spinWheel(options);
        model.addAttribute("result", result);
        return "index";
    }
}
