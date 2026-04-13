package org.ieee.sscs.team2.rider;

import java.util.List;
import java.util.Map;
import org.ieee.sscs.team2.user.User;

public class InMemoryRiderRepository implements RiderRepository {
  private Map<String, User> database;

  @Override
  public void save(Rider rider) {
    throw new UnsupportedOperationException("Unimplemented");
  }

  @Override
  public Rider findById(String id) {
    throw new UnsupportedOperationException("Unimplemented");
  }

  @Override
  public Rider findByUserId(String userId) {
    throw new UnsupportedOperationException("Unimplemented");
  }

  @Override
  public List<Rider> getAll() {
    throw new UnsupportedOperationException("Unimplemented");
  }
}
