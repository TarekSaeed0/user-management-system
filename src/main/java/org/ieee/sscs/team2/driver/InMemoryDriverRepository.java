package org.ieee.sscs.team2.driver;

import java.util.List;
import java.util.Map;
import org.ieee.sscs.team2.user.User;

public class InMemoryDriverRepository implements DriverRepository {
  private Map<String, User> database;

  @Override
  public void save(Driver driver) {
    throw new UnsupportedOperationException("Unimplemented");
  }

  @Override
  public Driver findById(String id) {
    throw new UnsupportedOperationException("Unimplemented");
  }

  @Override
  public Driver findByUserId(String userId) {
    throw new UnsupportedOperationException("Unimplemented");
  }

  @Override
  public List<Driver> findAll() {
    throw new UnsupportedOperationException("Unimplemented");
  }

  @Override
  public List<Driver> findAvailable() {
    throw new UnsupportedOperationException("Unimplemented");
  }

  @Override
  public List<Driver> findVerified() {
    throw new UnsupportedOperationException("Unimplemented");
  }
}
