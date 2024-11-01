package com.betrybe.agrix.ebytr.staff.models.repositories;

import com.betrybe.agrix.ebytr.staff.models.entities.Crop;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Crop repository.
 */
public interface CropRepository extends JpaRepository<Crop, Long> {

  /**
   * Find by harvest date between list.
   *
   * @param startDate the start date
   * @param endDate   the end date
   * @return the list
   */
  List<Crop> findByHarvestDateBetween(LocalDate startDate, LocalDate endDate);
}