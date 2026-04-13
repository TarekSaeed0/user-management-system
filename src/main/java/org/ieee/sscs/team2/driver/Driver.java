package org.ieee.sscs.team2.driver;

import org.ieee.sscs.team2.Identifiable;
import org.ieee.sscs.team2.user.User;

public class Driver extends User {
  private String driverId;
  private String userId;
  private double walletBalance;
  private int totalTrips;
  private String licenseNumber;
  private double ratingAverage;
  private boolean isAvailable;

  Driver(String fullName, String email, String phone, String licenseNumber) {
    throw new UnsupportedOperationException("Unimplemented");
  }

  @Override
  public String getId() {
    throw new UnsupportedOperationException("Unimplemented");
  }


  public String getDriverId() {
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

  public String getLicenseNumber() {
    throw new UnsupportedOperationException("Unimplemented");
  }

  public double getRatingAverage() {
    throw new UnsupportedOperationException("Unimplemented");
  }

  public boolean isAvailable() {
    throw new UnsupportedOperationException("Unimplemented");
  }

  public void setAvailable(boolean available) {
    throw new UnsupportedOperationException("Unimplemented");
  }

  public void recordCompletedTrip(double newRatingScore) {
    throw new UnsupportedOperationException("Unimplemented");
  }
}
