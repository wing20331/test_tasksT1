package com.example.api.demo.controller;

import com.example.api.demo.model.CharacterFrequency;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class FrequencyController{

    @PostMapping("/frequency")
    public List<CharacterFrequency> calculateFrequency(@RequestBody String input) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char ch : input.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        return frequencyMap.entrySet().stream()
                .map(e -> new CharacterFrequency(e.getKey(), e.getValue()))
                .sorted((a, b) -> Integer.compare(b.getFrequency(), a.getFrequency()))
                .collect(Collectors.toList());
    }
}
