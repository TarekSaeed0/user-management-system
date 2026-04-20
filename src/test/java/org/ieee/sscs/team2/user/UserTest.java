package org.ieee.sscs.team2.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.Instant;
import org.junit.jupiter.api.Test;

public class UserTest {
  @Test
  public void cantCreateUserWithInvalidArguments() {
    assertThrows(Exception.class,
        () -> new User(null, "john@domain.com", "123456789", UserRole.DRIVER));
    assertThrows(Exception.class,
        () -> new User("John Doe", null, "123456789", UserRole.DRIVER));
    assertThrows(Exception.class,
        () -> new User("John Doe", "john.com", "123456789", UserRole.DRIVER));
    assertThrows(Exception.class,
        () -> new User("John Doe", "john@domain.com", null, UserRole.DRIVER));
  }

  @Test
  public void canCreateUserWithValidArguments() {
    User user =
        new User("John Doe", "john@domain.com", "123456789", UserRole.DRIVER);

    assertEquals("John Doe", user.getFullName());
    assertEquals("john@domain.com", user.getEmail());
    assertEquals("123456789", user.getPhone());
    assertEquals(UserRole.DRIVER, user.getRole());
  }

  @Test
  public void cantSetInvalidFullName() {
    User user =
        new User("John Doe", "john@domain.com", "123456789", UserRole.DRIVER);

    assertThrows(Exception.class, () -> user.setFullName(null));
  }


  @Test
  public void canSetValidFullName() {
    User user =
        new User("John Doe", "john@domain.com", "123456789", UserRole.DRIVER);

    user.setFullName("Jane Doe");
    assertEquals("Jane Doe", user.getFullName());
  }

  @Test
  public void cantSetInvalidEmail() {
    User user =
        new User("John Doe", "john@domain.com", "123456789", UserRole.DRIVER);

    assertThrows(Exception.class, () -> user.setEmail(null));
    assertThrows(Exception.class, () -> user.setEmail(""));
    assertThrows(Exception.class, () -> user.setEmail("john.com"));
  }

  @Test
  public void canSetValidEmail() {
    User user =
        new User("John Doe", "john@domain.com", "123456789", UserRole.DRIVER);

    user.setEmail("jane@domain.com");
    assertEquals("jane@domain.com", user.getEmail());
  }

  @Test
  public void cantSetInvalidPhone() {
    User user =
        new User("John Doe", "john@domain.com", "123456789", UserRole.DRIVER);

    assertThrows(Exception.class, () -> user.setPhone(null));
  }

  @Test
  public void canSetValidPhone() {
    User user =
        new User("John Doe", "john@domain.com", "123456789", UserRole.DRIVER);

    user.setPhone("987654321");
    assertEquals("987654321", user.getPhone());
  }

  @Test
  public void cantSetInvalidPassword() {
    User user =
        new User("John Doe", "john@domain.com", "123456789", UserRole.DRIVER);

    assertThrows(Exception.class, () -> user.setPassword(null));
  }

  @Test
  public void checkPasswordReturnsFalseForWrongPassword() {
    User user =
        new User("John Doe", "john@domain.com", "123456789", UserRole.DRIVER);

    user.setPassword("correct_password");
    assertFalse(user.checkPassword("wrong_password"));
  }

  @Test
  public void checkPasswordReturnsTrueForCorrectPassword() {
    User user =
        new User("John Doe", "john@domain.com", "123456789", UserRole.DRIVER);

    user.setPassword("correct_password");
    assertTrue(user.checkPassword("correct_password"));
  }

  @Test
  public void IdIsSetOnCreation() {
    User user =
        new User("John Doe", "john@domain.com", "123456789", UserRole.DRIVER);

    assertNotNull(user.getId());
  }

  @Test
  public void createdAtIsSetOnCreation() {
    Instant beforeCreation = Instant.now();
    User user =
        new User("John Doe", "john@domain.com", "123456789", UserRole.DRIVER);
    Instant afterCreation = Instant.now();

    assertTrue(user.getCreatedAt().isAfter(beforeCreation));
    assertTrue(user.getCreatedAt().isBefore(afterCreation));
  }
}

