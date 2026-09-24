package com.github.konicai;

/**
 * Author:
 * Zane Labonte-Hagar
 * 101239002
 */
public record BuddyInfo(String name, String phoneNumber) {

    @Override
    public String toString() {
        return "Name: %s, Phone Number: %s".formatted(name, phoneNumber);
    }
}
