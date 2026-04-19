package org.ieee.sscs.team2.rider;

import org.ieee.sscs.team2.Identifiable;
import org.ieee.sscs.team2.user.User;
import org.ieee.sscs.team2.user.UserRole;

public class Rider extends User implements Identifiable{
  private String id;
  private String riderId;
  private String userId;
  private double walletBalance;
  private int totalTrips;

  Rider(String fullName, String email, String phone) {
    super (fullName, email, phone, UserRole.RIDER);
  }

  @Override
  public String getId() {
    return id;
  }

  public String getRiderId() {
    return riderId;
  }

  public String getUserId() {
    return userId;
  }

  public double getWalletBalance() {
    return walletBalance;
  }

  public int getTotalTrips() {
    return totalTrips;
  }
}
