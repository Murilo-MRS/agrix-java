package com.betrybe.agrix.ebytr.staff.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;

/**
 * The type Crop.
 */
@Entity
@Table(name = "crops")
public class Crop {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private double plantedArea;

  @ManyToOne
  @JoinColumn(name = "farm_id")
  private Farm farm;
  private LocalDate plantedDate;
  private LocalDate harvestDate;

  @ManyToMany
  @JoinTable(
      name = "crops_fertilizers",
      joinColumns = @JoinColumn(name = "crop_id"),
      inverseJoinColumns = @JoinColumn(name = "fertilizer_id")
  )
  private List<Fertilizer> fertilizers;

  /**
   * Instantiates a new Crop.
   */
  public Crop() {
  }

  /**
   * Instantiates a new Crop.
   *
   * @param plantedArea the planted area
   * @param name        the name
   * @param plantedDate the planted date
   * @param harvestDate the harvest date
   */
  public Crop(double plantedArea, String name, LocalDate plantedDate, LocalDate harvestDate) {
    this.plantedArea = plantedArea;
    this.name = name;
    this.plantedDate = plantedDate;
    this.harvestDate = harvestDate;
  }

  /**
   * Gets id.
   *
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets name.
   *
   * @param name the name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets planted area.
   *
   * @return the planted area
   */
  public double getPlantedArea() {
    return plantedArea;
  }

  /**
   * Sets planted area.
   *
   * @param plantedArea the planted area
   */
  public void setPlantedArea(double plantedArea) {
    this.plantedArea = plantedArea;
  }

  /**
   * Gets farm.
   *
   * @return the farm
   */
  public Farm getFarm() {
    return farm;
  }

  /**
   * Sets farm.
   *
   * @param farm the farm
   */
  public void setFarm(Farm farm) {
    this.farm = farm;
  }

  /**
   * Gets planted date.
   *
   * @return the planted date
   */
  public LocalDate getPlantedDate() {
    return plantedDate;
  }

  /**
   * Sets planted date.
   *
   * @param plantedDate the planted date
   */
  public void setPlantedDate(LocalDate plantedDate) {
    this.plantedDate = plantedDate;
  }

  /**
   * Gets harvest date.
   *
   * @return the harvest date
   */
  public LocalDate getHarvestDate() {
    return harvestDate;
  }

  /**
   * Sets harvest date.
   *
   * @param harvestDate the harvest date
   */
  public void setHarvestDate(LocalDate harvestDate) {
    this.harvestDate = harvestDate;
  }

  /**
   * Gets fertilizers.
   *
   * @return the fertilizers
   */
  public List<Fertilizer> getFertilizers() {
    return fertilizers;
  }

  /**
   * Sets fertilizers.
   *
   * @param fertilizers the fertilizers
   */
  public void setFertilizers(
      List<Fertilizer> fertilizers) {
    this.fertilizers = fertilizers;
  }
}
