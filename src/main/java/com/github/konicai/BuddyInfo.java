package com.github.konicai;

import java.util.Objects;

/**
 * Author:
 * Zane Labonte-Hagar
 * 101239002
 */
public final class BuddyInfo {

    private String name;
    private String phoneNumber;

    /// Default constructor for JPA only.
    public BuddyInfo() {

    }

    public BuddyInfo(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Name: %s, Phone Number: %s".formatted(name, phoneNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (BuddyInfo) obj;
        return Objects.equals(this.name, that.name) &&
                Objects.equals(this.phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber);
    }
}
