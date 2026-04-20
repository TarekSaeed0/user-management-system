package org.ieee.sscs.team2.rider;

import java.util.UUID;
import org.ieee.sscs.team2.user.User;
import org.ieee.sscs.team2.user.UserRole;

public class Rider extends User {
  private String riderId;
  private String userId;
  private double walletBalance;
  private int totalTrips;

  public Rider(String fullName, String email, String phone) {
    super(fullName, email, phone, UserRole.RIDER);
    this.riderId = UUID.randomUUID().toString();
    this.userId = super.getId();
    this.walletBalance = 0.0;
    this.totalTrips = 0;
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
