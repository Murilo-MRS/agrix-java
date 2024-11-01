package com.betrybe.agrix.ebytr.staff.security;

/**
 * Enum representing a Role.
 */
public enum Role {
  /**
   * Admin role.
   */
  ADMIN("ROLE_ADMIN"),
  /**
   * Manager role.
   */
  MANAGER("ROLE_MANAGER"),
  /**
   * User role.
   */
  USER("ROLE_USER");

  private final String name;

  Role(String name) {
    this.name = name;
  }

  /**
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }
}