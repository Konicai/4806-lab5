package com.github.konicai;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

/**
 * Author:
 * Zane Labonte-Hagar
 * 101239002
 */
@Entity
public class BuddyInfo {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String phoneNumber;

    /// Default constructor for JPA only.
    protected BuddyInfo() {

    }

    public BuddyInfo(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public boolean equals(Object o) {
        if (!(o instanceof BuddyInfo buddyInfo)) return false;
        return Objects.equals(id, buddyInfo.id) && Objects.equals(name, buddyInfo.name) && Objects.equals(phoneNumber, buddyInfo.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phoneNumber);
    }
}
