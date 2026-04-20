package org.ieee.sscs.team2.rider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRiderRepository implements RiderRepository {
  private static InMemoryRiderRepository instance;

  private Map<String, Rider> database = new HashMap<>();

  InMemoryRiderRepository() {}

  public static synchronized InMemoryRiderRepository getInstance() {
    if (instance == null) {
      instance = new InMemoryRiderRepository();
    }

    return instance;
  }

  @Override
  public void save(Rider rider) {
    this.database.put(rider.getRiderId(), rider);
  }

  @Override
  public Rider findById(String id) {
    return this.database.get(id);
  }

  @Override
  public Rider findByUserId(String userId) {
    for (Map.Entry<String, Rider> m : database.entrySet()) {
      Rider val = m.getValue();
      if (val.getUserId().equals(userId)) {
        return val;
      }
    }
    return null;
  }

  @Override
  public List<Rider> getAll() {
    List<Rider> temp = new ArrayList<Rider>();
    for (Map.Entry<String, Rider> m : database.entrySet()) {
      Rider val = m.getValue();
      temp.add(val);
    }
    return temp;
  }
}
