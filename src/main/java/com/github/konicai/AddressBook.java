package com.github.konicai;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Author:
 * Zane Labonte-Hagar
 * 101239002
 */
@Entity
public class AddressBook {

    @Id
    @GeneratedValue
    private Long id;

    // Cascade all operations so that we can persist BuddyInfos that are in this list that have not been individually
    // persisted yet.
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<BuddyInfo> info;

    /// Default constructor for JPA only.
    protected AddressBook() {
        this.info = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
