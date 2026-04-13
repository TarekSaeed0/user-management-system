package org.ieee.sscs.team2.user;

import java.util.List;
import org.ieee.sscs.team2.driver.Driver;
import org.ieee.sscs.team2.driver.DriverRepository;
import org.ieee.sscs.team2.rider.Rider;
import org.ieee.sscs.team2.rider.RiderRepository;

public class UserManager {
  private UserRepository userRepository;
  private RiderRepository riderRepository;
  private DriverRepository driverRepository;

  public UserManager(UserRepository userRepository,
      RiderRepository riderRepository, DriverRepository driverRepository) {
    throw new UnsupportedOperationException("Unimplemented");
  }

  public Rider registerRider(String fullName, String email, String phone,
      String password) {
    throw new UnsupportedOperationException("Unimplemented");
  }

  public Driver registerDriver(String fullName, String email, String phone,
      String password, String licenseNumber) {
    throw new UnsupportedOperationException("Unimplemented");
  }

  public User getUserById(String id) {
    throw new UnsupportedOperationException("Unimplemented");
  }

  public User getUserByEmail(String email) {
    throw new UnsupportedOperationException("Unimplemented");
  }

  public List<Driver> getAvailableDrivers() {
    throw new UnsupportedOperationException("Unimplemented");
  }

  public boolean isEmailRegistered(String email) {
    throw new UnsupportedOperationException("Unimplemented");
  }

  public boolean isPhoneRegistered(String phone) {
    throw new UnsupportedOperationException("Unimplemented");
  }

  public void setDriverAvailability(String driverId, boolean available) {
    throw new UnsupportedOperationException("Unimplemented");
  }
}
