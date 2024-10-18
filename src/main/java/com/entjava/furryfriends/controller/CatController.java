package com.entjava.furryfriends.controller;

import com.entjava.furryfriends.model.Cat;
import com.entjava.furryfriends.service.CatService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.security.core.Authentication;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/cats")
public class CatController {

    private final CatService catService;

    public CatController(CatService catService)
    {
        this.catService = catService;
    }

    @GetMapping
    public Map<String, Object> getAllCats(Authentication authentication)
    {
        List<Cat> cats = catService.findAllCats();

        Map<String, Object> response = new HashMap<>();
        response.put("user", authentication.getName());
        response.put("cats", cats);

        return response;
    }

    @PostMapping
    public Cat createCat(@RequestBody Cat cat)
    {
        return catService.saveCat(cat);
    }

    @DeleteMapping("/{id}")
    public void deleteCat(@PathVariable Long id)
    {
        catService.deleteCat(id);
    }
}

