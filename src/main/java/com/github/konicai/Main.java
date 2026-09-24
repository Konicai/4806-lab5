package com.github.konicai;

import java.util.List;

/**
 * Author:
 * Zane Labonte-Hagar
 * 101239002
 */
public class Main {

    public static void main(String[] args) {

        BuddyInfo info1 = new BuddyInfo("Charles", "111-111-1111");
        BuddyInfo info2 = new BuddyInfo("Frank", "222-222-2222");
        BuddyInfo info3 = new BuddyInfo("Herbet", "333-333-3333");

        List<BuddyInfo> infos = List.of(info1, info2, info3);

        AddressBook addressBook = new AddressBook(infos);

        System.out.println(addressBook.toString());
    }
}