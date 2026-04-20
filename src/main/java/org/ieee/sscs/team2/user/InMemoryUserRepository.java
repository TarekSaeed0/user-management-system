package org.ieee.sscs.team2.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryUserRepository implements UserRepository {
  private Map<String, User> database = new HashMap<String,User>();

  @Override
  public void save(User user) {
    database.put(user.getId(), user);
  }

  @Override
  public User findById(String id) {
    return database.get(id);
  }

  @Override
  public User findByEmail(String email) {
    for(String id : database.keySet()){
      if(email.equals(database.get(id).getEmail())){
        return database.get(id);
      }
    }
    return null;
  }

  @Override
  public User findByPhone(String phone) {
    for(String id : database.keySet()){
      if(phone.equals(database.get(id).getPhone())){
        return database.get(id);
      }
    }
    return null;
  }

  @Override
  public List<User> findAll() {
    List<User> users = new ArrayList<User>();
    for(User user : database.values()){
      users.add(user);
    }
    return users;
  }

  @Override
  public List<User> findByRole(UserRole role) {
    List<User> users = new ArrayList<User>();
    for(User user : database.values()){
      if(user.getRole() == role){
        users.add(user);
      }
    }
    return users;
  }
  

  @Override
  public boolean existsByEmail(String email) {
    for(String id : database.keySet()){
      if(email.equals(database.get(id).getEmail())){
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean existsByPhone(String phone) {
    for(String id : database.keySet()){
      if(phone.equals(database.get(id).getPhone())){
        return true;
      }
    }
    return false;
  }
  

  @Override
  public void delete(String id) {
    database.remove(id);
  }

}
