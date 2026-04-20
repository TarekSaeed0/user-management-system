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

  @BeforeAll
  public static void setup() {
    driver1.setAvailable(true);
  }

  @Test
  public void findByIdReturnsDriverWithThatDriverId() {
    InMemoryDriverRepository repository = new InMemoryDriverRepository();

    repository.save(driver1);
    repository.save(driver2);

    assertEquals(driver1, repository.findById(driver1.getDriverId()));
    assertEquals(driver2, repository.findById(driver2.getDriverId()));
  }

  @Test
  public void findByIdReturnsNullIfNoDriverWithThatDriverId() {
    InMemoryDriverRepository repository = new InMemoryDriverRepository();

    assertEquals(null, repository.findById("nonexistent-driver-id"));
  }

  @Test
  public void findByUserIdReturnsDriverWithThatUserId() {
    InMemoryDriverRepository repository = new InMemoryDriverRepository();

    repository.save(driver1);
    repository.save(driver2);

    assertEquals(driver1, repository.findByUserId(driver1.getUserId()));
    assertEquals(driver2, repository.findByUserId(driver2.getUserId()));
  }

  @Test
  public void findByUserIdReturnsNullIfNoDriverWithThatUserId() {
    InMemoryDriverRepository repository = new InMemoryDriverRepository();

    assertEquals(null, repository.findByUserId("nonexistent-user-id"));
  }

  @Test
  public void findAllReturnsAllDrivers() {
    InMemoryDriverRepository repository = new InMemoryDriverRepository();

    repository.save(driver1);
    repository.save(driver2);

    List<Driver> allDrivers = repository.findAll();

    assertEquals(2, allDrivers.size());

    assertTrue(allDrivers.contains(driver1));
    assertTrue(allDrivers.contains(driver2));
  }

  @Test
  public void findAvailableReturnsOnlyAvailableDrivers() {
    InMemoryDriverRepository repository = new InMemoryDriverRepository();

    repository.save(driver1);
    repository.save(driver2);

    List<Driver> availableDrivers = repository.findAvailable();

    assertEquals(1, availableDrivers.size());

    assertTrue(availableDrivers.contains(driver1));
  }

  @Test
  public void findVerifiedReturnsOnlyVerifiedDrivers() {
    InMemoryDriverRepository repository = new InMemoryDriverRepository();

    repository.save(driver1);
    repository.save(driver2);

    List<Driver> verifiedDrivers = repository.findVerified();

    assertEquals(2, verifiedDrivers.size());

    assertTrue(verifiedDrivers.contains(driver1));
    assertTrue(verifiedDrivers.contains(driver2));
  }
}
