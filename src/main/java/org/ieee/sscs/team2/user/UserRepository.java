package org.ieee.sscs.team2.user;

import java.util.List;

public interface UserRepository {
  void save(User user); // add the user to the hash table

  User findById(String id);

  User findByEmail(String email);

  User findByPhone(String phone);

  List<User> findAll();

  List<User> findByRole(UserRole role);

  boolean existsByEmail(String email);

  boolean existsByPhone(String phone);

  void delete(String id);
}
