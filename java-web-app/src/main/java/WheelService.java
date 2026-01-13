package com.example.demo;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;

@Service
public class WheelService {

    private final Random random = new Random();

    public String spinWheel(List<String> options) {
        if (options == null || options.isEmpty()) {
            return "No options provided!";
        }
        int index = random.nextInt(options.size());
        return options.get(index);
    }
}
