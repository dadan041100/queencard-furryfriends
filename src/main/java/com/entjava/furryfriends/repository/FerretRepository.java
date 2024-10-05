package com.entjava.furryfriends.repository;

import com.entjava.furryfriends.model.Ferret;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FerretRepository extends JpaRepository<Ferret, Long>
{

}
