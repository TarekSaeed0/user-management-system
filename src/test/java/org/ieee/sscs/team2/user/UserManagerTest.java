package org.ieee.sscs.team2.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.ieee.sscs.team2.driver.Driver;
import org.ieee.sscs.team2.driver.DriverRepository;
import org.ieee.sscs.team2.rider.Rider;
import org.ieee.sscs.team2.rider.RiderRepository;
import org.junit.jupiter.api.Test;

public class UserManagerTest {

  private static class MockUserRepository implements UserRepository {
    private final Map<String, User> database = new HashMap<>();

    @Override
    public void save(User user) {
      database.put(user.getId(), user);
    }

    @Override
    public User findById(String id) {
      return database.get(id);
    }

    @Override
    public User findByEmail(String email) {
      return database.values().stream()
          .filter(user -> user.getEmail().equals(email)).findFirst()
          .orElse(null);
    }

    @Override
    public User findByPhone(String phone) {
      return database.values().stream()
          .filter(user -> user.getPhone().equals(phone)).findFirst()
          .orElse(null);
    }

    @Override
    public List<User> findAll() {
      return new ArrayList<>(database.values());
    }

    @Override
    public List<User> findByRole(UserRole role) {
      return database.values().stream().filter(user -> user.getRole() == role)
          .toList();
    }

    @Override
    public boolean existsByEmail(String email) {
      return database.values().stream()
          .anyMatch(user -> user.getEmail().equals(email));
    }

    @Override
    public boolean existsByPhone(String phone) {
      return database.values().stream()
          .anyMatch(user -> user.getPhone().equals(phone));
    }

    @Override
    public void delete(String id) {
      database.remove(id);
    }
  }

  private static class MockRiderRepository implements RiderRepository {
    private final Map<String, Rider> database = new HashMap<>();

    @Override
    public void save(Rider rider) {
      database.put(rider.getRiderId(), rider);
    }

    @Override
    public Rider findById(String id) {
      return database.get(id);
    }

    @Override
    public Rider findByUserId(String userId) {
      return database.values().stream()
          .filter(rider -> rider.getRiderId().equals(userId)).findFirst()
          .orElse(null);
    }

    @Override
    public List<Rider> getAll() {
      return new ArrayList<>(database.values());
    }
  }

  private static class MockDriverRepository implements DriverRepository {
    private final Map<String, Driver> database = new HashMap<>();

    @Override
    public void save(Driver driver) {
      database.put(driver.getDriverId(), driver);
    }

    @Override
    public Driver findById(String id) {
      return database.get(id);
    }

    @Override
    public Driver findByUserId(String userId) {
      return database.values().stream()
          .filter(driver -> driver.getDriverId().equals(userId)).findFirst()
          .orElse(null);
    }

    @Override
    public List<Driver> findAll() {
      return new ArrayList<>(database.values());
    }

    @Override
    public List<Driver> findAvailable() {
      return database.values().stream().filter(Driver::isAvailable).toList();
    }

    @Override
    public List<Driver> findVerified() {
      return new ArrayList<>(database.values());
    }
  }

  @Test
  public void registerRiderAddsNewUserAndRider() {
    UserRepository userRepository = new MockUserRepository();
    RiderRepository riderRepository = new MockRiderRepository();
    DriverRepository driverRepository = new MockDriverRepository();

    UserManager userManager =
        new UserManager(userRepository, riderRepository, driverRepository);

    String fullName = "John Doe";
    String email = "john@domain.com";
    String phone = "123456789";
    String password = "password123";

    Rider rider = userManager.registerRider(fullName, email, phone, password);

    assertEquals(fullName, rider.getFullName());
    assertEquals(email, rider.getEmail());
    assertEquals(phone, rider.getPhone());
    assertTrue(rider.checkPassword(password));

    assertTrue(userManager.isEmailRegistered(email));
    assertTrue(userManager.isPhoneRegistered(phone));

    assertEquals(rider, userRepository.findById(rider.getUserId()));
    assertEquals(rider, riderRepository.findById(rider.getRiderId()));
  }

  @Test
  public void registerDriverAddsNewUserAndDriver() {
    UserRepository userRepository = new MockUserRepository();
    RiderRepository riderRepository = new MockRiderRepository();
    DriverRepository driverRepository = new MockDriverRepository();

    UserManager userManager =
        new UserManager(userRepository, riderRepository, driverRepository);

    String fullName = "John Doe";
    String email = "john@domain.com";
    String phone = "123456789";
    String password = "password123";
    String licenseNumber = "ABC123";

    Driver driver = userManager.registerDriver(fullName, email, phone, password,
        licenseNumber);

    assertEquals(fullName, driver.getFullName());
    assertEquals(email, driver.getEmail());
    assertEquals(phone, driver.getPhone());
    assertTrue(driver.checkPassword(password));
    assertEquals(licenseNumber, driver.getLicenseNumber());
    assertFalse(driver.isAvailable());

    assertEquals(driver, userRepository.findById(driver.getUserId()));
    assertEquals(driver, driverRepository.findById(driver.getDriverId()));
  }

  @Test
  public void cantRegisterRiderWithAlreadyRegisteredEmail() {
    UserRepository userRepository = new MockUserRepository();
    RiderRepository riderRepository = new MockRiderRepository();
    DriverRepository driverRepository = new MockDriverRepository();

    UserManager userManager =
        new UserManager(userRepository, riderRepository, driverRepository);

    String email = "john@domain.com";

    userManager.registerRider("John Doe", email, "123456789", "password123");

    assertThrows(Exception.class, () -> userManager.registerRider("Tim Smith",
        email, "222222222", "password123"));
  }

  @Test
  public void cantRegisterRiderWithAlreadyRegisteredPhone() {
    UserRepository userRepository = new MockUserRepository();
    RiderRepository riderRepository = new MockRiderRepository();
    DriverRepository driverRepository = new MockDriverRepository();

    UserManager userManager =
        new UserManager(userRepository, riderRepository, driverRepository);

    String phone = "123456789";

    userManager.registerRider("John Doe", "john@domain.com", phone,
        "password123");

    assertThrows(Exception.class, () -> userManager.registerRider("Jane Doe",
        "jane@domain.com", phone, "password123"));
  }

  @Test
  public void cantRegisterDriverWithAlreadyRegisteredEmail() {
    UserRepository userRepository = new MockUserRepository();
    RiderRepository riderRepository = new MockRiderRepository();
    DriverRepository driverRepository = new MockDriverRepository();

    UserManager userManager =
        new UserManager(userRepository, riderRepository, driverRepository);

    String email = "john@domain.com";

    userManager.registerDriver("John Doe", email, "123456789", "password123",
        "ABC123");

    assertThrows(Exception.class, () -> userManager.registerDriver("Jane Doe",
        email, "987654321", "password123", "ABC123"));
  }

  @Test
  public void cantRegisterDriverWithAlreadyRegisteredPhone() {
    UserRepository userRepository = new MockUserRepository();
    RiderRepository riderRepository = new MockRiderRepository();
    DriverRepository driverRepository = new MockDriverRepository();

    UserManager userManager =
        new UserManager(userRepository, riderRepository, driverRepository);

    String phone = "123456789";

    userManager.registerDriver("John Doe", "john@domain.com", phone,
        "password123", "ABC123");

    assertThrows(Exception.class, () -> userManager.registerDriver("Jane Doe",
        "jane@domain.com", phone, "password123", "ABC123"));
  }

  @Test
  public void getUserByIdReturnsUserWithThatId() {
    UserRepository userRepository = new MockUserRepository();
    RiderRepository riderRepository = new MockRiderRepository();
    DriverRepository driverRepository = new MockDriverRepository();

    UserManager userManager =
        new UserManager(userRepository, riderRepository, driverRepository);

    Rider rider = userManager.registerRider("John Doe", "john@domain.com",
        "123456789", "password123");

    assertEquals(rider, userManager.getUserById(rider.getId()));
  }

  @Test
  public void getUserByIdReturnsNullIfNoUserWithThatId() {
    UserRepository userRepository = new MockUserRepository();
    RiderRepository riderRepository = new MockRiderRepository();
    DriverRepository driverRepository = new MockDriverRepository();

    UserManager userManager =
        new UserManager(userRepository, riderRepository, driverRepository);

    assertEquals(null, userManager.getUserById("nonexistent-id"));
  }

  @Test
  public void getUserByEmailReturnsUserWithThatEmail() {
    UserRepository userRepository = new MockUserRepository();
    RiderRepository riderRepository = new MockRiderRepository();
    DriverRepository driverRepository = new MockDriverRepository();

    UserManager userManager =
        new UserManager(userRepository, riderRepository, driverRepository);

    String email = "john@domain.com";

    Rider rider = userManager.registerRider("John Doe", email, "123456789",
        "password123");

    assertEquals(rider, userManager.getUserByEmail(email));
  }

  @Test
  public void getUserByEmailReturnsNullIfNoUserWithThatEmail() {
    UserRepository userRepository = new MockUserRepository();
    RiderRepository riderRepository = new MockRiderRepository();
    DriverRepository driverRepository = new MockDriverRepository();

    UserManager userManager =
        new UserManager(userRepository, riderRepository, driverRepository);

    assertEquals(null, userManager.getUserByEmail("nonexistent@domain.com"));
  }

  @Test
  public void isEmailRegisteredReturnsTrueIfUserWithThatEmailExists() {
    UserRepository userRepository = new MockUserRepository();
    RiderRepository riderRepository = new MockRiderRepository();
    DriverRepository driverRepository = new MockDriverRepository();
    UserManager userManager =
        new UserManager(userRepository, riderRepository, driverRepository);

    String email = "john@domain.com";

    userManager.registerRider("John Doe", email, "123456789", "password123");

    assertTrue(userManager.isEmailRegistered(email));
  }

  @Test
  public void isEmailRegisteredReturnsFalseIfNoUserWithThatEmailExists() {
    UserRepository userRepository = new MockUserRepository();
    RiderRepository riderRepository = new MockRiderRepository();
    DriverRepository driverRepository = new MockDriverRepository();

    UserManager userManager =
        new UserManager(userRepository, riderRepository, driverRepository);

    assertFalse(userManager.isEmailRegistered("nonexistent@domain.com"));
  }

  @Test
  public void isPhoneRegisteredReturnsTrueIfUserWithThatPhoneExists() {
    UserRepository userRepository = new MockUserRepository();
    RiderRepository riderRepository = new MockRiderRepository();
    DriverRepository driverRepository = new MockDriverRepository();

    UserManager userManager =
        new UserManager(userRepository, riderRepository, driverRepository);

    String phone = "123456789";

    userManager.registerRider("John Doe", "john@domain.com", phone,
        "password123");

    assertTrue(userManager.isPhoneRegistered(phone));
  }

  @Test
  public void isPhoneRegisteredReturnsFalseIfNoUserWithThatPhoneExists() {
    UserRepository userRepository = new MockUserRepository();
    RiderRepository riderRepository = new MockRiderRepository();
    DriverRepository driverRepository = new MockDriverRepository();

    UserManager userManager =
        new UserManager(userRepository, riderRepository, driverRepository);

    assertFalse(userManager.isPhoneRegistered("000000000"));
  }

  @Test
  public void setDriverAvailabilityMakesDriverAvailable() {
    UserRepository userRepository = new MockUserRepository();
    RiderRepository riderRepository = new MockRiderRepository();
    DriverRepository driverRepository = new MockDriverRepository();

    UserManager userManager =
        new UserManager(userRepository, riderRepository, driverRepository);

    Driver driver = userManager.registerDriver("John Doe", "john@domain.com",
        "123456789", "password123", "ABC123");

    userManager.setDriverAvailability(driver.getDriverId(), true);
    assertTrue(driver.isAvailable());

    List<Driver> availableDrivers = userManager.getAvailableDrivers();
    assertTrue(availableDrivers.contains(driver));
  }

  @Test
  public void cantSetDriverAvailabilityForNonexistentDriver() {
    UserRepository userRepository = new MockUserRepository();
    RiderRepository riderRepository = new MockRiderRepository();
    DriverRepository driverRepository = new MockDriverRepository();

    UserManager userManager =
        new UserManager(userRepository, riderRepository, driverRepository);

    assertThrows(Exception.class,
        () -> userManager.setDriverAvailability("nonexistent-id", true));
  }
}
