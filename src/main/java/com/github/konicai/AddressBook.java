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

    private final List<BuddyInfo> info;

    public AddressBook(List<BuddyInfo> info) {
        this.info = new ArrayList<>(info);
    }

    public void addInfo(BuddyInfo info) {
        this.info.add(info);
    }

    public List<BuddyInfo> info() {
        return info;
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
