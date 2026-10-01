package com.github.konicai;

import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(Sysc4806LabApplication.class);

    private static void printAllAddressBook(AddressBookRepository addressBookRepo) {
        // Query for all BuddyInfo records and print them
        Iterable<AddressBook> results = addressBookRepo.findAll();

        LOGGER.info("All AddressBook:");
        for (AddressBook book : results) {
            LOGGER.info(book.toString());
        }
        LOGGER.info("");
    }

    private static void printAllBuddyInfo(BuddyInfoRepository buddyInfoRepository) {
        // Query for all BuddyInfo records and print them
        Iterable<BuddyInfo> results = buddyInfoRepository.findAll();

        LOGGER.info("All BuddyInfo:");
        for (BuddyInfo info : results) {
            LOGGER.info(info.toString());
        }
        LOGGER.info("");
    }

    public static void main(String[] args) {
        // This is use instead of application.properties
        System.setProperty("spring.application.name", "sysc4806-lab3");

        SpringApplication.run(Sysc4806LabApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(AddressBookRepository addressBookRepo, BuddyInfoRepository buddyInfoRepo) {
        return new CommandLineRunner() {

            /// This @Transactional annotation is required so that the following is run under one transaction.
            /// This allows `info1` and `info2` to be added to `book` after they have already been persisted themselves.
            /// Without this transaction, they would become detached entities after being saved,
            /// and attempting to add them to `book` and then persisting `book` would be rejected.
            @Transactional
            @Override
            public void run(String... args) {

                BuddyInfo info1 = new BuddyInfo("Zane", "1234");
                BuddyInfo info2 = new BuddyInfo("Ben", "555-555-5555");

                // BuddyInfo persistence test
                LOGGER.info("BuddyInfo persistence test");
                buddyInfoRepo.save(info1);
                buddyInfoRepo.save(info2);
                printAllBuddyInfo(buddyInfoRepo);

                // AddressBook persistance test follows
                LOGGER.info("AddressBook persistence test");

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
            }
        };
    }
}