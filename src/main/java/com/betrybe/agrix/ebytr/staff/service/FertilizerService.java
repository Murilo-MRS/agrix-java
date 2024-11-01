package com.betrybe.agrix.ebytr.staff.service;

import com.betrybe.agrix.ebytr.staff.exception.FertilizerNotFoundException;
import com.betrybe.agrix.ebytr.staff.models.entities.Fertilizer;
import com.betrybe.agrix.ebytr.staff.models.repositories.FertilizerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Fertilizer service.
 */
@Service
public class FertilizerService {
  private final FertilizerRepository fertilizerRepository;

  /**
   * Instantiates a new Fertilizer service.
   *
   * @param fertilizerRepository the fertilizer repository
   */
  @Autowired
  public FertilizerService(FertilizerRepository fertilizerRepository) {
    this.fertilizerRepository = fertilizerRepository;
  }

  /**
   * Find all list.
   *
   * @return the list
   */
  public List<Fertilizer> findAll() {
    return fertilizerRepository.findAll();
  }

  /**
   * Find by id fertilizer.
   *
   * @param id the id
   * @return the fertilizer
   * @throws FertilizerNotFoundException the crop not found exception
   */
  public Fertilizer findById(Long id) throws FertilizerNotFoundException {
    return fertilizerRepository.findById(id).orElseThrow(
        FertilizerNotFoundException::new
    );
  }

  /**
   * Create fertilizer.
   *
   * @param fertilizer the fertilizer
   * @return the fertilizer
   */
  public Fertilizer create(Fertilizer fertilizer) {
    return fertilizerRepository.save(fertilizer);
  }
}
