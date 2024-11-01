package com.betrybe.agrix.ebytr.staff.controllers;

import com.betrybe.agrix.ebytr.staff.controllers.dto.PersonCreationDto;
import com.betrybe.agrix.ebytr.staff.controllers.dto.PersonDto;
import com.betrybe.agrix.ebytr.staff.models.entities.Person;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Person controller.
 */
@RestController
@RequestMapping("/persons")
public class PersonController {
  private final PersonService personService;

  /**
   * Instantiates a new Person controller.
   *
   * @param personService the person service
   */
  @Autowired
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  /**
   * Create person response entity.
   *
   * @param personCreationDto the person creation dto
   * @return the response entity
   */
  @PostMapping
  public ResponseEntity<PersonDto> createPerson(@RequestBody PersonCreationDto personCreationDto) {
    PersonDto personDto = PersonDto.fromEntity(personService.create(personCreationDto.toEntity()));
    return ResponseEntity.status(HttpStatus.CREATED).body(personDto);
  }
}
