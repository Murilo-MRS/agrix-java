package com.betrybe.agrix.ebytr.staff.controllers;



import com.betrybe.agrix.ebytr.staff.controllers.dto.CropCreationDto;
import com.betrybe.agrix.ebytr.staff.controllers.dto.CropDto;
import com.betrybe.agrix.ebytr.staff.controllers.dto.FarmCreationDto;
import com.betrybe.agrix.ebytr.staff.controllers.dto.FarmDto;
import com.betrybe.agrix.ebytr.staff.exception.FarmNotFoundException;
import com.betrybe.agrix.ebytr.staff.models.entities.Crop;
import com.betrybe.agrix.ebytr.staff.service.FarmService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Farm controller.
 */
@RestController
@RequestMapping("/farms")
public class FarmController {
  private final FarmService farmService;

  /**
   * Instantiates a new Farm controller.
   *
   * @param farmService the farm service
   */
  @Autowired
  public FarmController(FarmService farmService) {
    this.farmService = farmService;
  }

  /**
   * Gets all farms.
   *
   * @return the all farms
   */
  @GetMapping
  @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER', 'USER')")
  public ResponseEntity<List<FarmDto>> getAllFarms() {
    List<FarmDto> farms = farmService.findAll().stream()
        .map(FarmDto::fromEntity)
        .toList();
    return ResponseEntity.ok(farms);
  }

  /**
   * Gets farm by id.
   *
   * @param id the id
   * @return the farm by id
   * @throws FarmNotFoundException the farm not found exception
   */
  @GetMapping("/{id}")
  public ResponseEntity<FarmDto> getFarmById(@PathVariable Long id) throws FarmNotFoundException {
    FarmDto farm = FarmDto.fromEntity(farmService.findById(id));
    return ResponseEntity.ok(farm);
  }

  /**
   * Gets crops from farm.
   *
   * @param farmId the farm id
   * @return the crops from farm
   * @throws FarmNotFoundException the farm not found exception
   */
  @GetMapping("/{farmId}/crops")
  public ResponseEntity<List<CropDto>> getCropsFromFarm(@PathVariable Long farmId)
      throws FarmNotFoundException {
    List<CropDto> crops = farmService.getCropsFromFarm(farmId).stream()
        .map(CropDto::fromEntity)
        .toList();
    return ResponseEntity.ok(crops);
  }

  /**
   * Create farm response entity.
   *
   * @param farmCreationDto the farm creation dto
   * @return the response entity
   */
  @PostMapping
  public ResponseEntity<FarmDto> createFarm(@RequestBody FarmCreationDto farmCreationDto) {
    FarmDto farmDto = FarmDto.fromEntity(farmService.create(farmCreationDto.toEntity()));
    return ResponseEntity.status(HttpStatus.CREATED).body(farmDto);
  }

  /**
   * Add crop to farm response entity.
   *
   * @param farmId          the farm id
   * @param cropCreationDto the crop creation dto
   * @return the response entity
   * @throws FarmNotFoundException the farm not found exception
   */
  @PostMapping("/{farmId}/crops")
  public ResponseEntity<CropDto> addCropToFarm(
      @PathVariable Long farmId,
      @RequestBody CropCreationDto cropCreationDto
  ) throws FarmNotFoundException {
    Crop crop = farmService.addCropToFarm(farmId, cropCreationDto.toEntity());
    CropDto cropDto = CropDto.fromEntity(crop);
    return ResponseEntity.status(HttpStatus.CREATED).body(cropDto);
  }
}
