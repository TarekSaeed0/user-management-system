package org.ieee.sscs.team2.user;

import java.util.List;
import java.util.Objects;
import org.ieee.sscs.team2.driver.Driver;
import org.ieee.sscs.team2.driver.DriverRepository;
import org.ieee.sscs.team2.rider.Rider;
import org.ieee.sscs.team2.rider.RiderRepository;

public class UserManager {
  private static UserManager instance;

  private UserRepository userRepository;
  private RiderRepository riderRepository;
  private DriverRepository driverRepository;

  UserManager(UserRepository userRepository, RiderRepository riderRepository,
      DriverRepository driverRepository) {
    this.userRepository = Objects.requireNonNull(userRepository,
        "User repository must not be null");
    this.riderRepository = Objects.requireNonNull(riderRepository,
        "Rider repository must not be null");
    this.driverRepository = Objects.requireNonNull(driverRepository,
        "Driver repository must not be null");
  }

  public static synchronized UserManager getInstance(
      UserRepository userRepository, RiderRepository riderRepository,
      DriverRepository driverRepository) {
    if (instance == null) {
      instance =
          new UserManager(userRepository, riderRepository, driverRepository);
    }

    return instance;
  }

  public Rider registerRider(String fullName, String email, String phone,
      String password) {
    if (isEmailRegistered(email)) {
      throw new IllegalArgumentException(
          "Email " + email + " is already registered");
    }

    if (isPhoneRegistered(phone)) {
      throw new IllegalArgumentException(
          "Phone " + phone + " is already registered");
    }

    Rider rider = new Rider(fullName, email, phone);
    rider.setPassword(password);

    userRepository.save(rider);
    riderRepository.save(rider);

    return rider;
  }

  public Driver registerDriver(String fullName, String email, String phone,
      String password, String licenseNumber) {
    if (isEmailRegistered(email)) {
      throw new IllegalArgumentException(
          "Email " + email + " is already registered");
    }

    if (isPhoneRegistered(phone)) {
      throw new IllegalArgumentException(
          "Phone " + phone + " is already registered");
    }

    Driver driver = new Driver(fullName, email, phone, licenseNumber);
    driver.setPassword(password);

    userRepository.save(driver);
    driverRepository.save(driver);

    return driver;
  }

  public User getUserById(String id) {
    Objects.requireNonNull(id, "User ID must not be null");

    return userRepository.findById(id);
  }

  public User getUserByEmail(String email) {
    Objects.requireNonNull(email, "Email must not be null");

    return userRepository.findByEmail(email);
  }

  public List<Driver> getAvailableDrivers() {
    return driverRepository.findAvailable();
  }

  public boolean isEmailRegistered(String email) {
    Objects.requireNonNull(email, "Email must not be null");

    return userRepository.existsByEmail(email);
  }

  public boolean isPhoneRegistered(String phone) {
    Objects.requireNonNull(phone, "Phone must not be null");

    return userRepository.existsByPhone(phone);
  }

  public void setDriverAvailability(String driverId, boolean available) {
    Objects.requireNonNull(driverId, "Driver ID must not be null");

    Driver driver = driverRepository.findById(driverId);
    if (driver == null) {
      throw new IllegalArgumentException(
          "Driver with ID " + driverId + " not found");
    }

    driver.setAvailable(available);
  }
}
