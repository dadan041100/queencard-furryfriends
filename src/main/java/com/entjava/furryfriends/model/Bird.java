package com.entjava.furryfriends.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data

public class Bird
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String color;
    private String species;
    private boolean flying;

}