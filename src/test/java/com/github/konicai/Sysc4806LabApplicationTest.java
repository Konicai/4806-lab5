package com.github.konicai;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class Sysc4806LabApplicationTest {

    @Autowired
    AddressBookWebController addressBookWebController;

    @Test
    void testContextLoads() {
        // Test that the application can actually start and that springboot properly initialized this test
        assertNotNull(addressBookWebController);
    }
}
