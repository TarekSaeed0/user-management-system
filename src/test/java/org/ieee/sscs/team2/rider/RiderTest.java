package org.ieee.sscs.team2.rider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.ieee.sscs.team2.user.UserRole;
import org.junit.jupiter.api.Test;

public class RiderTest {
  @Test
  public void cantCreateRiderWithInvalidArguments() {
    assertThrows(Exception.class,
        () -> new Rider(null, "john@domain.com", "123456789"));
    assertThrows(Exception.class,
        () -> new Rider("John Doe", null, "123456789"));
    assertThrows(Exception.class,
        () -> new Rider("John Doe", "john.com", "123456789"));
    assertThrows(Exception.class,
        () -> new Rider("John Doe", "john@domain.com", null));
  }

  @Test
  public void canCreateRiderWithValidArguments() {
    Rider rider = new Rider("John Doe", "john@domain.com", "123456789");

    assertEquals("John Doe", rider.getFullName());
    assertEquals("john@domain.com", rider.getEmail());
    assertEquals("123456789", rider.getPhone());
    assertEquals(UserRole.RIDER, rider.getRole());
    assertEquals(0, rider.getTotalTrips());
  }

  @Test
  public void RiderIdIsSetOnCreation() {
    Rider rider = new Rider("John Doe", "john@domain.com", "123456789");

    assertNotNull(rider.getRiderId());
  }

  @Test
  public void UserIdIsSetOnCreation() {
    Rider rider = new Rider("John Doe", "john@domain.com", "123456789");

    assertNotNull(rider.getUserId());
  }
}
