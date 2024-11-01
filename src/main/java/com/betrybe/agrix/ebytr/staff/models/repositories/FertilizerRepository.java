package com.betrybe.agrix.ebytr.staff.models.repositories;

import com.betrybe.agrix.ebytr.staff.models.entities.Fertilizer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Fertilizer repository.
 */
public interface FertilizerRepository extends JpaRepository<Fertilizer, Long> {

}
