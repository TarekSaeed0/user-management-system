package org.ieee.sscs.team2.user;

import java.util.List;
import java.util.Map;

public class InMemoryUserRepository implements UserRepository {
  private static InMemoryUserRepository instance;

  private Map<String, User> database;

  InMemoryUserRepository() {}

  public static synchronized InMemoryUserRepository getInstance() {
    if (instance == null) {
      instance = new InMemoryUserRepository();
    }

    return instance;
  }

  @Override
  public void save(User user) {
    throw new UnsupportedOperationException("Unimplemented");
  }

  @Override
  public User findById(String id) {
    throw new UnsupportedOperationException("Unimplemented");
  }

  @Override
  public User findByEmail(String email) {
    throw new UnsupportedOperationException("Unimplemented");
  }

  @Override
  public User findByPhone(String phone) {
    throw new UnsupportedOperationException("Unimplemented");
  }

  @Override
  public List<User> findAll() {
    throw new UnsupportedOperationException("Unimplemented");
  }

  @Override
  public List<User> findByRole(UserRole role) {
    throw new UnsupportedOperationException("Unimplemented");
  }

  @Override
  public boolean existsByEmail(String email) {
    throw new UnsupportedOperationException("Unimplemented");
  }

  @Override
  public boolean existsByPhone(String phone) {
    throw new UnsupportedOperationException("Unimplemented");
  }

  @Override
  public void delete(String id) {
    throw new UnsupportedOperationException("Unimplemented");
  }

}
