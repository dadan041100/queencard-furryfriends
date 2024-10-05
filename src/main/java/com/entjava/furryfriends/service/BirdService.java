package com.entjava.furryfriends.service;

import com.entjava.furryfriends.model.Bird;
import com.entjava.furryfriends.repository.BirdRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BirdService {

    private final BirdRepository birdRepository;

    public BirdService(BirdRepository birdRepository) {
        this.birdRepository = birdRepository;
    }

    public List<Bird> findAllBirds() {
        return birdRepository.findAll(); // Ensure this method retrieves all birds from the database
    }

    public Bird saveBird(Bird bird) {
        return birdRepository.save(bird); // Save bird to the database
    }

    public void deleteBird(Long id) {
        if (birdRepository.existsById(id)) {
            birdRepository.deleteById(id);
        }
    }
}
