package org.ieee.sscs.team2.rider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class InMemoryRiderRepositoryTest {
	private static Rider rider1 =
			new Rider("John Doe", "john@domain.com", "123456789");
	private static Rider rider2 =
			new Rider("Jane Doe", "jane@domain.com", "987654321");
	private static Rider rider3 =
			new Rider("Bob Williams", "bob@domain.com", "111111111");
	private static Rider rider4 =
			new Rider("Tim Smith", "tim@domain.com", "222222222");

	@BeforeAll
	public static void setup() {
		InMemoryRiderRepository repository = InMemoryRiderRepository.getInstance();

		repository.save(rider1);
		repository.save(rider2);
		repository.save(rider3);
		repository.save(rider4);
	}

	@Test
	public void findByIdReturnsRiderWithThatRiderId() {
		InMemoryRiderRepository repository = InMemoryRiderRepository.getInstance();

		assertEquals(rider1, repository.findById(rider1.getRiderId()));
		assertEquals(rider2, repository.findById(rider2.getRiderId()));
		assertEquals(rider3, repository.findById(rider3.getRiderId()));
		assertEquals(rider4, repository.findById(rider4.getRiderId()));
	}

	@Test
	public void findByIdReturnsNullIfNoRiderWithThatRiderId() {
		InMemoryRiderRepository repository = InMemoryRiderRepository.getInstance();

		assertEquals(null, repository.findById("nonexistent-rider-id"));
	}

	@Test
	public void findByUserIdReturnsRiderWithThatUserId() {
		InMemoryRiderRepository repository = InMemoryRiderRepository.getInstance();

		assertEquals(rider1, repository.findByUserId(rider1.getUserId()));
		assertEquals(rider2, repository.findByUserId(rider2.getUserId()));
		assertEquals(rider3, repository.findByUserId(rider3.getUserId()));
		assertEquals(rider4, repository.findByUserId(rider4.getUserId()));
	}

	@Test
	public void findByUserIdReturnsNullIfNoRiderWithThatUserId() {
		InMemoryRiderRepository repository = InMemoryRiderRepository.getInstance();

		assertEquals(null, repository.findByUserId("nonexistent-user-id"));
	}

	@Test
	public void getAllReturnsAllRiders() {
		InMemoryRiderRepository repository = InMemoryRiderRepository.getInstance();

		List<Rider> allRiders = repository.getAll();

		assertEquals(4, allRiders.size());

		assertTrue(allRiders.contains(rider1));
		assertTrue(allRiders.contains(rider2));
		assertTrue(allRiders.contains(rider3));
		assertTrue(allRiders.contains(rider4));
	}
}
