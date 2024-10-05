package com.entjava.furryfriends.controller;

import com.entjava.furryfriends.model.Ferret;
import com.entjava.furryfriends.service.FerretService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ferrets")
public class FerretController
{

    private final FerretService FerretService;

    public FerretController(FerretService FerretService)
    {
        this.FerretService = FerretService;
    }

    @GetMapping
    public List<Ferret> getAllFerrets()
    {
        return FerretService.findAllFerrets();
    }

    @PostMapping
    public Ferret createFerret(@RequestBody Ferret ferret)
    {
        return FerretService.saveFerret(ferret);
    }

    @DeleteMapping("/{id}")
    public void deleteFerret(@PathVariable Long id)
    {
        FerretService.deleteFerret(id);
    }
}

