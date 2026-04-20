package org.ieee.sscs.team2.driver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.ieee.sscs.team2.user.UserRole;
import org.junit.jupiter.api.Test;

public class DriverTest {
  @Test
  public void cantCreateDriverWithInvalidArguments() {
    assertThrows(Exception.class,
        () -> new Driver(null, "john@domain.com", "123456789", "ABC123"));
    assertThrows(Exception.class,
        () -> new Driver("John Doe", null, "123456789", "ABC123"));
    assertThrows(Exception.class,
        () -> new Driver("John Doe", "john.com", "123456789", "ABC123"));
    assertThrows(Exception.class,
        () -> new Driver("John Doe", "john@domain.com", null, "ABC123"));
    assertThrows(Exception.class,
        () -> new Driver("John Doe", "john@domain.com", "123456789", null));
  }

  @Test
  public void canCreateDriverWithValidArguments() {
    Driver driver =
        new Driver("John Doe", "john@domain.com", "123456789", "ABC123");

    assertEquals("John Doe", driver.getFullName());
    assertEquals("john@domain.com", driver.getEmail());
    assertEquals("123456789", driver.getPhone());
    assertEquals(UserRole.DRIVER, driver.getRole());
    assertEquals(0, driver.getTotalTrips());
    assertEquals("ABC123", driver.getLicenseNumber());
    assertEquals(0, driver.getRatingAverage());
    assertFalse(driver.isAvailable());
  }

  @Test
  public void canSetAvailability() {
    Driver driver =
        new Driver("John Doe", "john@domain.com", "123456789", "ABC123");

    driver.setAvailable(true);
    assertTrue(driver.isAvailable());

    driver.setAvailable(false);
    assertFalse(driver.isAvailable());
  }

  @Test
  public void recordCompletedTripUpdatesTotalRidesAndRatingAverage() {
    Driver driver =
        new Driver("John Doe", "john@domain.com", "123456789", "ABC123");

    driver.recordCompletedTrip(5);
    assertEquals(1, driver.getTotalTrips());
    assertEquals(5, driver.getRatingAverage());

    driver.recordCompletedTrip(3);
    assertEquals(2, driver.getTotalTrips());
    assertEquals(4, driver.getRatingAverage());

    driver.recordCompletedTrip(4);
    assertEquals(3, driver.getTotalTrips());
    assertEquals(4, driver.getRatingAverage());

    driver.recordCompletedTrip(2);
    assertEquals(4, driver.getTotalTrips());
    assertEquals(3.5, driver.getRatingAverage());
  }

  @Test
  public void DriverIdIsSetOnCreation() {
    Driver driver =
        new Driver("John Doe", "john@domain.com", "123456789", "ABC123");

    assertNotNull(driver.getDriverId());
  }

  @Test
  public void UserIdIsSetOnCreation() {
    Driver driver =
        new Driver("John Doe", "john@domain.com", "123456789", "ABC123");

    assertNotNull(driver.getUserId());
  }
}
