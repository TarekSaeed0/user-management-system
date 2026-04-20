package org.ieee.sscs.team2.driver;

import org.ieee.sscs.team2.user.User;
import org.ieee.sscs.team2.user.UserRole;
import java.util.UUID;

public class Driver extends User {
  private String driverId;
  private String userId;
  private double walletBalance;
  private int totalTrips;
  private String licenseNumber;
  private double ratingAverage;
  private boolean isAvailable;

  public Driver(String fullName, String email, String phone,
      String licenseNumber) {
    super(fullName, email, phone, UserRole.DRIVER);
    this.driverId = UUID.randomUUID().toString();
    this.userId = super.getId();
    this.walletBalance = 0.0;
    this.totalTrips = 0;
    if (licenseNumber != null)
      this.licenseNumber = licenseNumber;
    else
      throw new IllegalArgumentException("You must enter licenseNumber");
    this.ratingAverage = 0.0;
    this.isAvailable = false;
  }

  public String getDriverId() {
    return this.driverId;
  }

  public String getUserId() {
    return this.userId;
  }

  public double getWalletBalance() {
    return this.walletBalance;
  }

  public int getTotalTrips() {
    return this.totalTrips;
  }

  public String getLicenseNumber() {
    return this.licenseNumber;
  }

  public double getRatingAverage() {
    return this.ratingAverage;
  }

  public boolean isAvailable() {
    return this.isAvailable;
  }

  public void setAvailable(boolean available) {
    this.isAvailable = available;
  }

  public void recordCompletedTrip(double newRatingScore) {
    this.ratingAverage =
        (ratingAverage * totalTrips + newRatingScore) / (totalTrips + 1);
    this.totalTrips++;
  }

}
