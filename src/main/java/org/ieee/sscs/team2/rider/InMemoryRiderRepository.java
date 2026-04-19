package org.ieee.sscs.team2.rider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.ieee.sscs.team2.user.User;

public class InMemoryRiderRepository implements RiderRepository {
  private Map<String, User> database;

  @Override
  public void save(Rider rider) {
    this.database.put(rider.getId(), rider);
  }

  @Override
  public Rider findById(String id) {
    return (Rider) this.database.get(id);
  }

  @Override
  public Rider findByUserId(String userId) {
    for (Map.Entry<String, User> m : database.entrySet()) {
        String key = m.getKey();
        User val = m.getValue();
        if (((Rider)val).getUserId().equals(userId)){
          return (Rider) val;
        }
    }
    return null;
  }

  @Override
  public List<Rider> getAll() {
    List<Rider> temp = new ArrayList<Rider>();
    for (Map.Entry<String, User> m : database.entrySet()) {
        User val = m.getValue();
        temp.add((Rider) val);
      }
      return temp;
  }
}
