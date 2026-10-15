package com.github.konicai;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author:
 * Zane Labonte-Hagar
 * 101239002
 */
class AddressBookTest {

    @Test
    void testEmpty() {
        AddressBook book = new AddressBook(Collections.emptyList());

        assertEquals(List.of(), book.getInfo());

        String expectedToString = """
                AddressBook:""";
        assertEquals(expectedToString, book.toString());
    }

    @Test
    void testSingle() {
        AddressBook book = new AddressBook(
                "My First Book",
                List.of(new BuddyInfo("Mark", "123-456")
        ));

        List<BuddyInfo> expectedInfo = List.of(new BuddyInfo("Mark", "123-456"));
        assertEquals(expectedInfo, book.getInfo());

        String expectedToString = """
                AddressBook:
                AddressBook Name: My First Book
                Name: Mark, Phone Number: 123-456""";
        assertEquals(expectedToString, book.toString());
    }

    @Test
    void testMultiple() {
        AddressBook book = new AddressBook(
                "My First Book",
                List.of(
                        new BuddyInfo("Mark", "123-456"),
                        new BuddyInfo("Adrian", "123456789")
        ));

        List<BuddyInfo> expectedInfo = List.of(
                new BuddyInfo("Mark", "123-456"),
                new BuddyInfo("Adrian", "123456789"));
        assertEquals(expectedInfo, book.getInfo());

        String expectedToString = """
                AddressBook:
                AddressBook Name: My First Book
                Name: Mark, Phone Number: 123-456
                Name: Adrian, Phone Number: 123456789""";
        assertEquals(expectedToString, book.toString());
    }

    @Test
    void testAddBuddy() {
        AddressBook book = new AddressBook(new ArrayList<>());

        BuddyInfo info = new BuddyInfo("Zane", "1234");
        BuddyInfo info2 = new BuddyInfo("Zane", "1234");

        book.addInfoEntry(info);

        assertEquals(info2, book.getInfo().getFirst());
        assertEquals(1, book.getInfo().size());
    }
}