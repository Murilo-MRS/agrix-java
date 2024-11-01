package com.betrybe.agrix.ebytr.staff.exception;

/**
 * Exception for when a person is not found.
 */
public class PersonNotFoundException extends RuntimeException {

  /**
   * Instantiates a new Person not found exception.
   */
  public PersonNotFoundException() {
    super("Pessoa não encontrada!");
  }

}
