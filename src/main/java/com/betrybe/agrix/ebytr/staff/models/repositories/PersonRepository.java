package com.betrybe.agrix.ebytr.staff.models.repositories;

import com.betrybe.agrix.ebytr.staff.models.entities.Person;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Person JPA repository.
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

  /**
   * Find by username optional.
   *
   * @param username the username
   * @return the optional
   */
  Optional<Person> findByUsername(String username);
}
