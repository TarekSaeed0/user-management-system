package org.ieee.sscs.team2.driver;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import org.ieee.sscs.team2.user.User;

public class InMemoryDriverRepository implements DriverRepository {
  private Map<String, Driver> database=new HashMap<>();

  @Override
  public void save(Driver driver) {
    database.put(driver.getDriverId(),driver);
  }

  @Override
  public Driver findById(String id) {
    return this.database.get(id);
  }

  @Override
  public Driver findByUserId(String userId) {
    for(Driver driver : database.values()){
      if(userId.equals(driver.getId())){
        return driver;
      }
    }
    throw new UnsupportedOperationException("There is no user with this ID");
  }

  @Override
  public List<Driver> findAll() {
    return new ArrayList<>(database.values());
  }

  @Override
  public List<Driver> findAvailable() {
    List<Driver> availableDrivers=new ArrayList<>();
    for(Driver driver:database.values()){
      if(driver.isAvailable()==true){
        availableDrivers.add(driver);
      }
    }
    return availableDrivers;
  }

  @Override
  public List<Driver> findVerified() {
    // List<Driver> verifiedDrivers=new ArrayList<>(); 
    // for(Driver driver:drivers){
    //   if(driver.isVerified()==true){
    //     verifiedDrivers.add(driver);
    //   }
    // }
    // return verifiedDrivers;
    //since we suppose that all of the drivers are verified i commented the pecie of code above
    //untill we use it or something similar to it 
    return new ArrayList<Driver>(database.values());//i returned all of the drivers   
  }

}