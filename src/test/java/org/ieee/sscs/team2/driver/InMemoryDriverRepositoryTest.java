package org.ieee.sscs.team2.driver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class InMemoryDriverRepositoryTest {
  private static Driver driver1 =
      new Driver("John Doe", "john@domain.com", "123456789", "ABC123");
  private static Driver driver2 =
      new Driver("Jane Doe", "jane@domain.com", "987654321", "DEF456");
  private static Driver driver3 =
      new Driver("Bob Williams", "bob@domain.com", "111111111", "GHI789");
  private static Driver driver4 =
      new Driver("Tim Smith", "tim@domain.com", "222222222", "JKL012");

  @BeforeAll
  public static void setup() {
    InMemoryDriverRepository repository =
        InMemoryDriverRepository.getInstance();

    driver1.setAvailable(true);
    driver3.setAvailable(true);

    repository.save(driver1);
    repository.save(driver2);
    repository.save(driver3);
    repository.save(driver4);
  }

  @Test
  public void findByIdReturnsDriverWithThatDriverId() {
    InMemoryDriverRepository repository =
        InMemoryDriverRepository.getInstance();

    assertEquals(driver1, repository.findById(driver1.getDriverId()));
    assertEquals(driver2, repository.findById(driver2.getDriverId()));
    assertEquals(driver3, repository.findById(driver3.getDriverId()));
    assertEquals(driver4, repository.findById(driver4.getDriverId()));
  }

  @Test
  public void findByIdReturnsNullIfNoDriverWithThatDriverId() {
    InMemoryDriverRepository repository =
        InMemoryDriverRepository.getInstance();

    assertEquals(null, repository.findById("nonexistent-driver-id"));
  }

  @Test
  public void findByUserIdReturnsDriverWithThatUserId() {
    InMemoryDriverRepository repository =
        InMemoryDriverRepository.getInstance();

    assertEquals(driver1, repository.findByUserId(driver1.getUserId()));
    assertEquals(driver2, repository.findByUserId(driver2.getUserId()));
    assertEquals(driver3, repository.findByUserId(driver3.getUserId()));
    assertEquals(driver4, repository.findByUserId(driver4.getUserId()));
  }

  @Test
  public void findByUserIdReturnsNullIfNoDriverWithThatUserId() {
    InMemoryDriverRepository repository =
        InMemoryDriverRepository.getInstance();

    assertEquals(null, repository.findByUserId("nonexistent-user-id"));
  }

  @Test
  public void findAllReturnsAllDrivers() {
    InMemoryDriverRepository repository =
        InMemoryDriverRepository.getInstance();

    List<Driver> allDrivers = repository.findAll();

    assertEquals(4, allDrivers.size());

    assertTrue(allDrivers.contains(driver1));
    assertTrue(allDrivers.contains(driver2));
    assertTrue(allDrivers.contains(driver3));
    assertTrue(allDrivers.contains(driver4));
  }

  @Test
  public void findAvailableReturnsOnlyAvailableDrivers() {
    InMemoryDriverRepository repository =
        InMemoryDriverRepository.getInstance();

    List<Driver> availableDrivers = repository.findAvailable();

    assertEquals(2, availableDrivers.size());

    assertTrue(availableDrivers.contains(driver1));
    assertTrue(availableDrivers.contains(driver3));
  }

  @Test
  public void findVerifiedReturnsOnlyVerifiedDrivers() {
    InMemoryDriverRepository repository =
        InMemoryDriverRepository.getInstance();

    List<Driver> verifiedDrivers = repository.findVerified();

    assertEquals(4, verifiedDrivers.size());

    assertTrue(verifiedDrivers.contains(driver1));
    assertTrue(verifiedDrivers.contains(driver2));
    assertTrue(verifiedDrivers.contains(driver3));
    assertTrue(verifiedDrivers.contains(driver4));
  }
}
