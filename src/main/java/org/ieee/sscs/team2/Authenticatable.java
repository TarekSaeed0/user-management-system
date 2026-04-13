package org.ieee.sscs.team2;

public interface Authenticatable {
  /**
   * Stores a hashed version of the given raw password in the object password
   * field. Must never store plaintext.
   */
  void setPassword(String rawPassword);

  /**
   * Returns true if the given raw password matches the stored hash. Must be
   * safe against null input.
   */
  boolean checkPassword(String rawPassword);
}
