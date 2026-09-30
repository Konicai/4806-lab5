package com.github.konicai;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

/**
 * Author:
 * Zane Labonte-Hagar
 * 101239002
 */
@SpringBootApplication
public class Sysc4806LabApplication {

    private static void printAllAddressBook(AddressBookRepository addressBookRepo) {
        // Query for all BuddyInfo records and print them
        Iterable<AddressBook> results = addressBookRepo.findAll();

        System.out.println("All AddressBook:");
        for (AddressBook book : results) {
            System.out.println(book.toString());
        }
        System.out.println();
    }

    private static void printAllBuddyInfo(BuddyInfoRepository buddyInfoRepository) {
        // Query for all BuddyInfo records and print them
        Iterable<BuddyInfo> results = buddyInfoRepository.findAll();

        System.out.println("All BuddyInfo:");
        for (BuddyInfo info : results) {
            System.out.println(info.toString());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // This is use instead of application.properties
        System.setProperty("spring.application.name", "sysc4806-lab3");

        SpringApplication.run(Sysc4806LabApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(AddressBookRepository addressBookRepo, BuddyInfoRepository buddyInfoRepo) {
        return (args) -> {

            BuddyInfo info1 = new BuddyInfo("Zane", "1234");
            BuddyInfo info2 = new BuddyInfo("Ben", "555-555-5555");

            // BuddyInfo persistence test
            System.out.println("BuddyInfo persistence test");
            buddyInfoRepo.save(info1);
            buddyInfoRepo.save(info2);
            printAllBuddyInfo(buddyInfoRepo);

            // AddressBook persistance test follows
            System.out.println("AddressBook persistence test");

            // Create new book
            AddressBook book = new AddressBook(new ArrayList<>());
            // Add BuddyInfos that already exist in the BuddyInfoRepository
            book.addInfoEntry(info1);
            book.addInfoEntry(info2);

            // Add BuddyInfo that does not yet exist in the BuddyInfoRepository
            BuddyInfo newInfo3 = new BuddyInfo("Bradley", "6789");
            book.addInfoEntry(newInfo3);

            // Save the AddressBook
            addressBookRepo.save(book);

            printAllBuddyInfo(buddyInfoRepo);
            printAllAddressBook(addressBookRepo);
        };
    }
}