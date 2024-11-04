package com.betrybe.agrix.ebytr.staff.controllers;


import com.betrybe.agrix.ebytr.staff.controllers.dto.CropDto;
import com.betrybe.agrix.ebytr.staff.controllers.dto.FertilizerDto;
import com.betrybe.agrix.ebytr.staff.exception.CropNotFoundException;
import com.betrybe.agrix.ebytr.staff.exception.FertilizerNotFoundException;
import com.betrybe.agrix.ebytr.staff.models.entities.Crop;
import com.betrybe.agrix.ebytr.staff.models.entities.Fertilizer;
import com.betrybe.agrix.ebytr.staff.service.CropService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Crop controller.
 */
@RestController
@RequestMapping("/crops")
public class CropController {
  private final CropService cropService;

  /**
   * Instantiates a new Crop controller.
   *
   * @param cropService the crop service
   */
  @Autowired
  public CropController(CropService cropService) {
    this.cropService = cropService;
  }

  /**
   * Gets crop by id.
   *
   * @param id the id
   * @return the crop by id
   * @throws CropNotFoundException the crop not found exception
   */
  @GetMapping("/{id}")
  public ResponseEntity<CropDto> getCropById(@PathVariable Long id) throws CropNotFoundException {
    Crop crop = cropService.findById(id);
    return ResponseEntity.ok().body(CropDto.fromEntity(crop));
  }

  /**
   * Gets all crops.
   *
   * @return the all crops
   */
  @GetMapping
  @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
  public ResponseEntity<List<CropDto>> getAllCrops() {

    List<CropDto> crops = cropService.findAll().stream()
        .map(CropDto::fromEntity)
        .toList();
    return ResponseEntity.ok().body(crops);
  }

  /**
   * Gets crop by harvest date.
   *
   * @param start the start date
   * @param end   the end date
   * @return the crop by harvest date
   */
  @GetMapping("/search")
  public ResponseEntity<List<CropDto>> getCropByHarvestDate(
      @RequestParam LocalDate start,
      @RequestParam LocalDate end
  ) {
    List<CropDto> crops = cropService.findCropByHarvestDate(start, end).stream()
        .map(CropDto::fromEntity)
        .toList();
    return ResponseEntity.ok().body(crops);
  }

  /**
   * Gets fertilizers by crop id.
   *
   * @param id the id
   * @return the fertilizers by crop id
   * @throws CropNotFoundException the crop not found exception
   */
  @GetMapping("/{id}/fertilizers")
  public ResponseEntity<List<FertilizerDto>> getFertilizersByCropId(@PathVariable Long id)
      throws CropNotFoundException {
    List<Fertilizer> fertilizers = cropService.getFertilizersByCropId(id);
    return ResponseEntity.ok().body(fertilizers.stream()
        .map(FertilizerDto::fromEntity)
        .toList());
  }

  /**
   * Add fertilizer to crop response entity.
   *
   * @param id           the id
   * @param fertilizerId the fertilizer id
   * @return the response entity
   * @throws CropNotFoundException       the crop not found exception
   * @throws FertilizerNotFoundException the fertilizer not found exception
   */
  @PostMapping("/{id}/fertilizers/{fertilizerId}")
  public ResponseEntity<String> addFertilizerToCrop(
      @PathVariable Long id,
      @PathVariable Long fertilizerId
  )
      throws CropNotFoundException, FertilizerNotFoundException {
    cropService.addFertilizerToCrop(id, fertilizerId);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body("Fertilizante e plantação associados com sucesso!");
  }
}
