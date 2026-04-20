package org.ieee.sscs.team2.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(org.junit.jupiter.api.MethodOrderer.OrderAnnotation.class)
public class InMemoryUserRepositoryTest {
	private static User user1 =
			new User("John Doe", "john@domain.com", "123456789", UserRole.DRIVER);
	private static User user2 =
			new User("Jane Doe", "jane@domain.com", "987654321", UserRole.RIDER);

	@Test
	public void findByIdReturnsUserWithThatId() {
		InMemoryUserRepository repository = new InMemoryUserRepository();

		repository.save(user1);
		repository.save(user2);

		assertEquals(user1, repository.findById(user1.getId()));
		assertEquals(user2, repository.findById(user2.getId()));
	}

	@Test
	public void findByIdReturnsNullIfNoUserWithThatId() {
		InMemoryUserRepository repository = new InMemoryUserRepository();

		assertEquals(null, repository.findById("nonexistent-id"));
	}

	@Test
	public void findByEmailReturnsUserWithThatEmail() {
		InMemoryUserRepository repository = new InMemoryUserRepository();

		repository.save(user1);
		repository.save(user2);

		assertEquals(user1, repository.findByEmail(user1.getEmail()));
		assertEquals(user2, repository.findByEmail(user2.getEmail()));
	}

	@Test
	public void findByEmailReturnsNullIfNoUserWithThatEmail() {
		InMemoryUserRepository repository = new InMemoryUserRepository();

		assertEquals(null, repository.findByEmail("nonexistent@domain.com"));
	}

	@Test
	public void findByPhoneReturnsUserWithThatPhone() {
		InMemoryUserRepository repository = new InMemoryUserRepository();

		repository.save(user1);
		repository.save(user2);

		assertEquals(user1, repository.findByPhone(user1.getPhone()));
		assertEquals(user2, repository.findByPhone(user2.getPhone()));
	}

	@Test
	public void findByPhoneReturnsNullIfNoUserWithThatPhone() {
		InMemoryUserRepository repository = new InMemoryUserRepository();

		assertEquals(null, repository.findByPhone("000000000"));
	}

	@Test
	public void getAllReturnsAllUsers() {
		InMemoryUserRepository repository = new InMemoryUserRepository();

		repository.save(user1);
		repository.save(user2);

		List<User> allUsers = repository.findAll();

		assertEquals(2, allUsers.size());

		assertTrue(allUsers.contains(user1));
		assertTrue(allUsers.contains(user2));
	}

	@Test
	public void existsByEmailReturnsTrueIfUserWithThatEmailExists() {
		InMemoryUserRepository repository = new InMemoryUserRepository();

		repository.save(user1);
		repository.save(user2);

		assertTrue(repository.existsByEmail(user1.getEmail()));
		assertTrue(repository.existsByEmail(user2.getEmail()));
	}

	@Test
	public void existsByEmailReturnsFalseIfNoUserWithThatEmailExists() {
		InMemoryUserRepository repository = new InMemoryUserRepository();


		assertFalse(repository.existsByEmail("nonexistent@domain.com"));
	}


	@Test
	public void existsByPhoneReturnsTrueIfUserWithThatPhoneExists() {
		InMemoryUserRepository repository = new InMemoryUserRepository();

		repository.save(user1);
		repository.save(user2);

		assertTrue(repository.existsByPhone(user1.getPhone()));
		assertTrue(repository.existsByPhone(user2.getPhone()));
	}

	@Test
	public void existsByPhoneReturnsFalseIfNoUserWithThatPhoneExists() {
		InMemoryUserRepository repository = new InMemoryUserRepository();

		assertFalse(repository.existsByPhone("000000000"));
	}

	@Test
	public void deleteRemovesUserWithThatId() {
		InMemoryUserRepository repository = new InMemoryUserRepository();

		repository.save(user1);
		repository.save(user2);

		repository.delete(user1.getId());

		assertNull(repository.findById(user1.getId()));
		assertEquals(user2, repository.findById(user2.getId()));
	}
}
