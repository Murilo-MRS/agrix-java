package com.betrybe.agrix.ebytr.staff.service;

import com.betrybe.agrix.ebytr.staff.exception.CropNotFoundException;
import com.betrybe.agrix.ebytr.staff.exception.FertilizerNotFoundException;
import com.betrybe.agrix.ebytr.staff.models.entities.Crop;
import com.betrybe.agrix.ebytr.staff.models.entities.Fertilizer;
import com.betrybe.agrix.ebytr.staff.models.repositories.CropRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Crop service.
 */
@Service
public class CropService {

  private final CropRepository cropRepository;
  private final FertilizerService fertilizerService;

  /**
   * Instantiates a new Crop service.
   *
   * @param cropRepository    the crop repository
   * @param fertilizerService the fertilizer service
   */
  @Autowired
  public CropService(CropRepository cropRepository, FertilizerService fertilizerService) {
    this.cropRepository = cropRepository;
    this.fertilizerService = fertilizerService;
  }

  /**
   * Find all list.
   *
   * @return the list
   */
  public List<Crop> findAll() {
    return cropRepository.findAll();
  }

  /**
   * Find by id crop.
   *
   * @param id the id
   * @return the crop
   * @throws CropNotFoundException the crop not found exception
   */
  public Crop findById(Long id) throws CropNotFoundException {
    return cropRepository.findById(id).orElseThrow(
        CropNotFoundException::new
    );
  }

  /**
   * Gets fertilizers by crop id.
   *
   * @param cropId the crop id
   * @return the fertilizers by crop id
   * @throws CropNotFoundException the crop not found exception
   */
  public List<Fertilizer> getFertilizersByCropId(Long cropId) throws CropNotFoundException {
    Crop crop = this.findById(cropId);
    return crop.getFertilizers();
  }

  /**
   * Find crop by harvestdate list.
   *
   * @param startDate the start date
   * @param endDate   the end date
   * @return the list
   */
  public List<Crop> findCropByHarvestDate(LocalDate startDate, LocalDate endDate) {
    return cropRepository.findByHarvestDateBetween(startDate, endDate);
  }

  /**
   * Add fertilizer to crop list.
   *
   * @param cropId       the crop id
   * @param fertilizerId the fertilizer id
   * @return the list
   * @throws CropNotFoundException       the crop not found exception
   * @throws FertilizerNotFoundException the fertilizer not found exception
   */
  public List<Fertilizer> addFertilizerToCrop(Long cropId, Long fertilizerId)
      throws CropNotFoundException, FertilizerNotFoundException {
    Crop crop = this.findById(cropId);
    Fertilizer fertilizer = fertilizerService.findById(fertilizerId);

    crop.getFertilizers().add(fertilizer);
    cropRepository.save(crop);

    return crop.getFertilizers();
  }
}
