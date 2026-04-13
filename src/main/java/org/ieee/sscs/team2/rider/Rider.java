package org.ieee.sscs.team2.rider;

import org.ieee.sscs.team2.user.User;

public class Rider extends User {
  private String riderId;
  private String userId;
  private double walletBalance;
  private int totalTrips;

  Rider(String fullName, String email, String phone) {
    throw new UnsupportedOperationException("Unimplemented");
  }

  @Override
  public String getId() {
    throw new UnsupportedOperationException("Unimplemented");
  }

  public String getRiderId() {
    throw new UnsupportedOperationException("Unimplemented");
  }

  public String getUserId() {
    throw new UnsupportedOperationException("Unimplemented");
  }

  public double getWalletBalance() {
    throw new UnsupportedOperationException("Unimplemented");
  }

  public int getTotalTrips() {
    throw new UnsupportedOperationException("Unimplemented");
  }
}
