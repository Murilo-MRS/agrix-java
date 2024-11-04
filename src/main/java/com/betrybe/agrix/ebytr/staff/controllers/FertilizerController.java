package com.betrybe.agrix.ebytr.staff.controllers;

import com.betrybe.agrix.ebytr.staff.controllers.dto.FertilizerCreationDto;
import com.betrybe.agrix.ebytr.staff.controllers.dto.FertilizerDto;
import com.betrybe.agrix.ebytr.staff.exception.FertilizerNotFoundException;
import com.betrybe.agrix.ebytr.staff.service.FertilizerService;
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
 * The type Fertilizer controller.
 */
@RestController
@RequestMapping("/fertilizers")
public class FertilizerController {
  private final FertilizerService fertilizerService;

  /**
   * Instantiates a new Fertilizer controller.
   *
   * @param fertilizerService the fertilizer service
   */
  @Autowired
  public FertilizerController(FertilizerService fertilizerService) {
    this.fertilizerService = fertilizerService;
  }

  /**
   * Find all response entity.
   *
   * @return the response entity
   */
  @GetMapping
  @PreAuthorize("hasAnyAuthority('ADMIN')")
  public ResponseEntity<List<FertilizerDto>> findAll() {
    List<FertilizerDto> fertilizers = fertilizerService.findAll().stream()
        .map(FertilizerDto::fromEntity)
        .toList();
    return ResponseEntity.ok(fertilizers);
  }

  /**
   * Find by id response entity.
   *
   * @param id the id
   * @return the response entity
   * @throws FertilizerNotFoundException the fertilizer not found exception
   */
  @GetMapping("/{id}")
  public ResponseEntity<FertilizerDto> findById(@PathVariable Long id)
      throws FertilizerNotFoundException {
    FertilizerDto fertilizer = FertilizerDto.fromEntity(fertilizerService.findById(id));
    return ResponseEntity.ok(fertilizer);
  }

  /**
   * Create response entity.
   *
   * @param fertilizerCreationDto the fertilizer creation dto
   * @return the response entity
   */
  @PostMapping
  public ResponseEntity<FertilizerDto> createFertilizer(
      @RequestBody FertilizerCreationDto fertilizerCreationDto
  ) {
    FertilizerDto fertilizerDto = FertilizerDto
        .fromEntity(fertilizerService.create(fertilizerCreationDto.toEntity()));
    return ResponseEntity.status(HttpStatus.CREATED).body(fertilizerDto);
  }
}
