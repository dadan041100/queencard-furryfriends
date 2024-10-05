package com.entjava.furryfriends.controller;

import com.entjava.furryfriends.model.Bird;
import com.entjava.furryfriends.service.BirdService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/birds")
public class BirdController
{

    private final BirdService BirdService;

    public BirdController(BirdService BirdService)
    {
        this.BirdService = BirdService;
    }

    @GetMapping
    public List<Bird> getAllBirds()
    {
        return BirdService.findAllBirds();
    }

    @PostMapping
    public Bird createBird(@RequestBody Bird bird)
    {
        return BirdService.saveBird(bird);
    }

    @DeleteMapping("/{id}")
    public void deleteBird(@PathVariable Long id)
    {
        BirdService.deleteBird(id);
    }
}

