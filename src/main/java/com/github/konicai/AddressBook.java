package com.github.konicai;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Author:
 * Zane Labonte-Hagar
 * 101239002
 */
public final class AddressBook {

    private List<BuddyInfo> info;

    /// Default constructor for JPA only.
    public AddressBook() {

    }

    public AddressBook(List<BuddyInfo> info) {
        this.info = new ArrayList<>(info);
    }

    public void addInfoEntry(BuddyInfo info) {
        this.info.add(info);
    }

    public List<BuddyInfo> getInfo() {
        return info;
    }

    public void setInfo(List<BuddyInfo> info) {
        this.info = info;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("\n");

        // Header
        joiner.add("AddressBook:");

        // Entries
        info.stream()
                .map(BuddyInfo::toString)
                .forEachOrdered(joiner::add);

        return joiner.toString();
    }
}
