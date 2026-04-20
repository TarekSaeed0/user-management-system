package org.ieee.sscs.team2.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(org.junit.jupiter.api.MethodOrderer.OrderAnnotation.class)
public class InMemoryUserRepositoryTest {
	private static User user1 =
			new User("John Doe", "john@domain.com", "123456789", UserRole.DRIVER);
	private static User user2 =
			new User("Jane Doe", "jane@domain.com", "987654321", UserRole.RIDER);
	private static User user3 =
			new User("Bob Williams", "bob@domain.com", "111111111", UserRole.RIDER);
	private static User user4 =
			new User("Tim Smith", "tim@domain.com", "222222222", UserRole.DRIVER);

	@BeforeAll
	public static void setup() {
		InMemoryUserRepository repository = InMemoryUserRepository.getInstance();

		repository.save(user1);
		repository.save(user2);
		repository.save(user3);
		repository.save(user4);
	}

	@Test
	public void findByIdReturnsUserWithThatId() {
		InMemoryUserRepository repository = InMemoryUserRepository.getInstance();

		assertEquals(user1, repository.findById(user1.getId()));
		assertEquals(user2, repository.findById(user2.getId()));
		assertEquals(user3, repository.findById(user3.getId()));
		assertEquals(user4, repository.findById(user4.getId()));
	}

	@Test
	public void findByIdReturnsNullIfNoUserWithThatId() {
		InMemoryUserRepository repository = InMemoryUserRepository.getInstance();

		assertEquals(null, repository.findById("nonexistent-id"));
	}

	@Test
	public void findByEmailReturnsUserWithThatEmail() {
		InMemoryUserRepository repository = InMemoryUserRepository.getInstance();

		assertEquals(user1, repository.findByEmail(user1.getEmail()));
		assertEquals(user2, repository.findByEmail(user2.getEmail()));
		assertEquals(user3, repository.findByEmail(user3.getEmail()));
		assertEquals(user4, repository.findByEmail(user4.getEmail()));
	}

	@Test
	public void findByEmailReturnsNullIfNoUserWithThatEmail() {
		InMemoryUserRepository repository = InMemoryUserRepository.getInstance();

		assertEquals(null, repository.findByEmail("nonexistent@domain.com"));
	}

	@Test
	public void findByPhoneReturnsUserWithThatPhone() {
		InMemoryUserRepository repository = InMemoryUserRepository.getInstance();

		assertEquals(user1, repository.findByPhone(user1.getPhone()));
		assertEquals(user2, repository.findByPhone(user2.getPhone()));
		assertEquals(user3, repository.findByPhone(user3.getPhone()));
		assertEquals(user4, repository.findByPhone(user4.getPhone()));
	}

	@Test
	public void findByPhoneReturnsNullIfNoUserWithThatPhone() {
		InMemoryUserRepository repository = InMemoryUserRepository.getInstance();

		assertEquals(null, repository.findByPhone("000000000"));
	}

	@Test
	public void getAllReturnsAllUsers() {
		InMemoryUserRepository repository = InMemoryUserRepository.getInstance();

		List<User> allUsers = repository.findAll();

		assertEquals(4, allUsers.size());

		assertTrue(allUsers.contains(user1));
		assertTrue(allUsers.contains(user2));
		assertTrue(allUsers.contains(user3));
		assertTrue(allUsers.contains(user4));
	}

	@Test
	public void existsByEmailReturnsTrueIfUserWithThatEmailExists() {
		InMemoryUserRepository repository = InMemoryUserRepository.getInstance();

		assertTrue(repository.existsByEmail(user1.getEmail()));
		assertTrue(repository.existsByEmail(user2.getEmail()));
		assertTrue(repository.existsByEmail(user3.getEmail()));
		assertTrue(repository.existsByEmail(user4.getEmail()));
	}

	@Test
	public void existsByEmailReturnsFalseIfNoUserWithThatEmailExists() {
		InMemoryUserRepository repository = InMemoryUserRepository.getInstance();

		assertFalse(repository.existsByEmail("nonexistent@domain.com"));
	}


	@Test
	public void existsByPhoneReturnsTrueIfUserWithThatPhoneExists() {
		InMemoryUserRepository repository = InMemoryUserRepository.getInstance();

		assertTrue(repository.existsByPhone(user1.getPhone()));
		assertTrue(repository.existsByPhone(user2.getPhone()));
		assertTrue(repository.existsByPhone(user3.getPhone()));
		assertTrue(repository.existsByPhone(user4.getPhone()));
	}

	@Test
	public void existsByPhoneReturnsFalseIfNoUserWithThatPhoneExists() {
		InMemoryUserRepository repository = InMemoryUserRepository.getInstance();

		assertFalse(repository.existsByPhone("000000000"));
	}

	@Test
	public void deleteRemovesUserWithThatId() {
		InMemoryUserRepository repository = InMemoryUserRepository.getInstance();

		repository.delete(user1.getId());
		assertNull(repository.findById(user1.getId()));

		repository.save(user1);
	}
}
