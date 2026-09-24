package com.github.konicai;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author:
 * Zane Labonte-Hagar
 * 101239002
 */
class BuddyInfoTest {

    @Test
    void testBasic() {
        BuddyInfo info = new BuddyInfo("Ben", "111-1");
        assertEquals("Ben", info.getName());
        assertEquals("111-1", info.getPhoneNumber());
    }

    @Test
    void testNoPhoneNumber() {
        BuddyInfo info = new BuddyInfo("James", "");
        assertEquals("James", info.getName());
        assertEquals("", info.getPhoneNumber());
    }

    @Test
    void testToString() {
        BuddyInfo info = new BuddyInfo("James", "111-111");
        String expected = "Name: James, Phone Number: 111-111";
        assertEquals(expected, info.toString());
    }
}
