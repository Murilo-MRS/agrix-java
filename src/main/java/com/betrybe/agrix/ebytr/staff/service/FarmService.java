package com.betrybe.agrix.ebytr.staff.service;

import com.betrybe.agrix.ebytr.staff.exception.FarmNotFoundException;
import com.betrybe.agrix.ebytr.staff.models.entities.Crop;
import com.betrybe.agrix.ebytr.staff.models.entities.Farm;
import com.betrybe.agrix.ebytr.staff.models.repositories.CropRepository;
import com.betrybe.agrix.ebytr.staff.models.repositories.FarmRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Farm service.
 */
@Service
public class FarmService {
  private final FarmRepository farmRepository;
  private final CropRepository cropRepository;

  /**
   * Instantiates a new Farm service.
   *
   * @param farmRepository the farm repository
   * @param cropRepository the crop repository
   */
  @Autowired
  public FarmService(FarmRepository farmRepository, CropRepository cropRepository) {
    this.farmRepository = farmRepository;
    this.cropRepository = cropRepository;
  }

  /**
   * Find all list.
   *
   * @return the list
   */
  public List<Farm> findAll() {
    return farmRepository.findAll();
  }

  /**
   * Find by id farm.
   *
   * @param id the id
   * @return the farm
   * @throws FarmNotFoundException the farm not found exception
   */
  public Farm findById(Long id) throws FarmNotFoundException {
    return farmRepository.findById(id).orElseThrow(
        FarmNotFoundException::new
    );
  }

  /**
   * Create farm.
   *
   * @param farm the farm
   * @return the farm
   */
  public Farm create(Farm farm) {
    return farmRepository.save(farm);
  }

  /**
   * Gets crops from farm.
   *
   * @param id the id
   * @return the crops from farm
   * @throws FarmNotFoundException the farm not found exception
   */
  public List<Crop> getCropsFromFarm(Long id) throws FarmNotFoundException {
    Farm farm = findById(id);

    return farm.getCrops();
  }

  /**
   * Add crop to farm crop.
   *
   * @param farmId the farm id
   * @param crop   the crop
   * @return the crop
   * @throws FarmNotFoundException the farm not found exception
   */
  public Crop addCropToFarm(Long farmId, Crop crop) throws FarmNotFoundException {
    Farm farm = findById(farmId);
    crop.setFarm(farm);
    return cropRepository.save(crop);
  }
}
