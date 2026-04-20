package org.ieee.sscs.team2.rider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.junit.jupiter.api.Test;

public class InMemoryRiderRepositoryTest {
	private static Rider rider1 =
			new Rider("John Doe", "john@domain.com", "123456789");
	private static Rider rider2 =
			new Rider("Jane Doe", "jane@domain.com", "987654321");

	@Test
	public void findByIdReturnsRiderWithThatRiderId() {
		InMemoryRiderRepository repository = new InMemoryRiderRepository();

		repository.save(rider1);

		assertEquals(rider1, repository.findById(rider1.getRiderId()));
	}

	@Test
	public void findByIdReturnsNullIfNoRiderWithThatRiderId() {
		InMemoryRiderRepository repository = new InMemoryRiderRepository();

		repository.save(rider1);
		repository.save(rider2);

		assertEquals(null, repository.findById("nonexistent-rider-id"));
	}

	@Test
	public void findByUserIdReturnsRiderWithThatUserId() {
		InMemoryRiderRepository repository = new InMemoryRiderRepository();

		repository.save(rider1);
		repository.save(rider2);

		assertEquals(rider1, repository.findByUserId(rider1.getUserId()));
		assertEquals(rider2, repository.findByUserId(rider2.getUserId()));
	}

	@Test
	public void findByUserIdReturnsNullIfNoRiderWithThatUserId() {
		InMemoryRiderRepository repository = new InMemoryRiderRepository();

		assertEquals(null, repository.findByUserId("nonexistent-user-id"));
	}

	@Test
	public void getAllReturnsAllRiders() {
		InMemoryRiderRepository repository = new InMemoryRiderRepository();

		repository.save(rider1);
		repository.save(rider2);

		List<Rider> allRiders = repository.getAll();

		assertEquals(2, allRiders.size());

		assertTrue(allRiders.contains(rider1));
		assertTrue(allRiders.contains(rider2));
	}
}
