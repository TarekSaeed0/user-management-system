package org.ieee.sscs.team2.rider;

import java.util.List;

public interface RiderRepository {
  void save(Rider rider);

  /**
   * gets the rider object by its user id, Note that they are not the same each
   * have its id
   **/
  Rider findById(String id);

  Rider findByUserId(String userId);

  List<Rider> getAll();
}
