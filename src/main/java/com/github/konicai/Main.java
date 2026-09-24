package com.github.konicai;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:
 * Zane Labonte-Hagar
 * 101239002
 */
public class Main {

    private static void printAllAddressBook(EntityManager em) {
        // Query for all BuddyInfo records and print them
        Query q = em.createQuery("SELECT a from AddressBook a");

        List<AddressBook> results = q.getResultList();

        System.out.println("All AddressBook:");
        for (AddressBook book : results) {
            System.out.println(book.toString());
        }
        System.out.println();
    }

    private static void printAllBuddyInfo(EntityManager em) {
        // Query for all BuddyInfo records and print them
        Query q = em.createQuery("SELECT b from BuddyInfo b");

        List<BuddyInfo> results = q.getResultList();

        System.out.println("All BuddyInfo:");
        for (BuddyInfo info : results) {
            System.out.println(info.toString());
        }
        System.out.println();
    }

    public static void main(String[] args) {

        BuddyInfo info1 = new BuddyInfo("Zane", "1234");
        BuddyInfo info2 = new BuddyInfo("Ben", "555-555-5555");

        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test")) {

            // BuddyInfo persistence test
            System.out.println("BuddyInfo persistence test");
            try (EntityManager em = emf.createEntityManager()) {

                // Persist the two BuddyInfos
                EntityTransaction tx = em.getTransaction();
                tx.begin();

                em.persist(info1);
                em.persist(info2);

                tx.commit();

                printAllBuddyInfo(em);
            }

            AddressBook book = new AddressBook(new ArrayList<>());
            book.addInfoEntry(info1);
            book.addInfoEntry(info2);

            // AddressBook persistence test
            System.out.println("AddressBook persistence test");
            try (EntityManager em = emf.createEntityManager()) {

                EntityTransaction tx = em.getTransaction();
                tx.begin();

                em.persist(book);

                tx.commit();

                printAllBuddyInfo(em);
                printAllAddressBook(em);
            }
        }
    }
}