package com.github.konicai;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

/**
 * Author:
 * Zane Labonte-Hagar
 * 101239002
 */
public class Main {

    public static void main(String[] args) {

        // BuddyInfo persistence test

        BuddyInfo info1 = new BuddyInfo("Zane", "1234");
        BuddyInfo info2 = new BuddyInfo("Ben", "555-555-5555");

        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test")) {

            try (EntityManager em = emf.createEntityManager()) {

                // Persist the two BuddyInfos
                EntityTransaction tx = em.getTransaction();
                tx.begin();

                em.persist(info1);
                em.persist(info2);

                tx.commit();

                // Query for all BuddyInfo records and print them
                Query q = em.createQuery("SELECT b from BuddyInfo b");

                List<BuddyInfo> results = q.getResultList();

                System.out.println("BuddyInfos:");
                for (BuddyInfo info : results) {
                    System.out.println(info.toString());
                }
            }
        }
    }
}