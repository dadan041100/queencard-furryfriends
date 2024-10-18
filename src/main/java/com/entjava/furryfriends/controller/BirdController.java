package com.entjava.furryfriends.controller;

import com.entjava.furryfriends.model.Bird;
import com.entjava.furryfriends.service.BirdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.security.core.Authentication;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/birds")
public class BirdController
{
    @Autowired
    private final BirdService BirdService;
    @Autowired
    private BirdService birdService;

    public BirdController(BirdService BirdService)
    {
        this.BirdService = BirdService;
    }

    @GetMapping
    public Map<String, Object> getAllBirds(Authentication authentication)
    {
        List<Bird> birds = birdService.findAllBirds();

        Map<String, Object> response = new HashMap<>();
        response.put("user", authentication.getName());
        response.put("birds", birds);

        return response;
    }

    @PostMapping
    public Bird createBird(@RequestBody Bird bird)
    {
        Bird savedBird = BirdService.saveBird(bird);
        return ResponseEntity.ok(savedBird).getBody();
    }

    @DeleteMapping("/{id}")
    public void deleteBird(@PathVariable Long id)
    {
        BirdService.deleteBird(id);
    }
}
