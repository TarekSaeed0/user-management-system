package org.ieee.sscs.team2.driver;

import java.util.List;

public interface DriverRepository {
  void save(Driver driver);

  Driver findById(String id);

  Driver findByUserId(String userId);

  List<Driver> findAll();

  List<Driver> findAvailable();

  List<Driver> findVerified();
}
