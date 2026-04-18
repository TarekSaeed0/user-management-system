package org.ieee.sscs.team2.user;

import java.time.Instant;
import java.util.UUID;
import org.apache.commons.validator.routines.EmailValidator;

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

  User(String fullName, String email, String phone, UserRole role) {
    setFullName(fullName);
    setEmail(email);
    setPhone(phone);
    this.role = role;
    this.id = UUID.randomUUID().toString();
    this.createdAt = Instant.now();
  }

  @Override
  public String getId() {
    return this.id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    if(EmailValidator.getInstance().isValid(email)){
      throw new IllegalArgumentExceptio("Please Enter Valid Email address");
    }
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }


  public void setPhone(String phone) {
    if(phone == null){
      throw new IllegalArgumentException("Please enter Phone Number :");
    }
    this.phone = phone;
  }

  @Override
  public void setPassword(String rawPassword) {
    passwordHashed = PasswordHashing.hashPassword(rawPassword);
  }

  @Override
  public boolean checkPassword(String rawPassword) {
    if(PasswordHashing.hashPassword(rawPassword) == passwordHashed){
      return true;
    }
    return false;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    if(fullName == null){
      throw new IllegalArgumentException("Please enter Full Name :");
    }
    this.fullName = fullName;
  }

  public UserRole getRole() {
    return role;
  }

  @Override
  public Instant getCreatedAt() {
    return createdAt;
  }
}
