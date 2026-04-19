package org.ieee.sscs.team2.user;

import java.time.Instant;

import org.ieee.sscs.team2.Auditable;
import org.ieee.sscs.team2.Authenticatable;
import org.ieee.sscs.team2.Identifiable;

public class User implements Identifiable, Auditable, Authenticatable {
  private String id;
  private String email;
  private String phone;
  private String passwordHashed;
  private String fullName;
  private UserRole role;
  private Instant createdAt;

  public User(String fullName, String email, String phone, UserRole role) {
    throw new UnsupportedOperationException("Unimplemented");
  }

  @Override
  public String getId() {
    throw new UnsupportedOperationException("Unimplemented");
  }

  public String getEmail() {
    throw new UnsupportedOperationException("Unimplemented");
  }

  public void setEmail(String email) {
    throw new UnsupportedOperationException("Unimplemented");
  }

  public String getPhone() {
    throw new UnsupportedOperationException("Unimplemented");
  }


  public void setPhone(String phone) {
    throw new UnsupportedOperationException("Unimplemented");
  }

  @Override
  public void setPassword(String rawPassword) {
    throw new UnsupportedOperationException("Unimplemented");
  }

  @Override
  public boolean checkPassword(String rawPassword) {
    throw new UnsupportedOperationException("Unimplemented");
  }

  public String getFullName() {
    throw new UnsupportedOperationException("Unimplemented");
  }

  public void setFullName(String fullName) {
    throw new UnsupportedOperationException("Unimplemented");
  }

  public UserRole getRole() {
    throw new UnsupportedOperationException("Unimplemented");
  }

  @Override
  public Instant getCreatedAt() {
    throw new UnsupportedOperationException("Unimplemented");
  }
}
