package com.entjava.furryfriends.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data

public class Ferret
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String size;
    private boolean trained;

}