package com.github.konicai;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.client.RestTestClient;

import java.net.URI;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@AutoConfigureRestTestClient
public class RestControllersTest {

    @Autowired
    RestTestClient restClient;

    @Test
    void testGetAddressBooks() {
        // These are already populated by the application on startup, so they are guaranteed to exist
        restClient.get().uri("/addressBooks")
                .exchangeSuccessfully()
                .expectBody()
                .consumeWith(System.out::println)
                .jsonPath("$._embedded.addressBooks[0]._links.self.href").isEqualTo("http://localhost/addressBooks/1")
                .jsonPath("$._embedded.addressBooks[0].name").isEqualTo("Zane's Book")
                .jsonPath("$._embedded.addressBooks[0]._links.info.href").isEqualTo("http://localhost/addressBooks/1/info")
                .jsonPath("$._embedded.addressBooks[1]._links.self.href").isEqualTo("http://localhost/addressBooks/2")
                .jsonPath("$._embedded.addressBooks[1].name").isEqualTo("Empty Book")
                .jsonPath("$._embedded.addressBooks[1]._links.info.href").isEqualTo("http://localhost/addressBooks/2/info");
    }

    @Test
    void testGetBuddyInfos() {
        // These are already populated by the application on startup, so they are guaranteed to exist
        restClient.get().uri("/buddyInfoes")
                .exchangeSuccessfully()
                .expectBody()
                .jsonPath("$._embedded.buddyInfoes").isArray()
                .jsonPath("$._embedded.buddyInfoes[0].name").isEqualTo("Zane")
                .jsonPath("$._embedded.buddyInfoes[0].phoneNumber").isEqualTo("1234")
                .jsonPath("$._embedded.buddyInfoes[1].name").isEqualTo("Ben")
                .jsonPath("$._embedded.buddyInfoes[2].name").isEqualTo("Bradley");
    }

    @Test
    void testPostAddressBook() {
        URI location = createAddressBook();

        restClient.get().uri(location)
                .exchangeSuccessfully()
                .expectBody()
                .jsonPath("$.name").isEqualTo("TestBook");

        assertThat(location.toString()).matches(".*/addressBooks/\\d+");
    }

    @Test
    void testPostBuddyInfo() {
        URI location = restClient.post().uri("/buddyInfoes")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaTypes.HAL_JSON)
                .body("""
                    {"name": "Bjorn", "phoneNumber": "1024-2048-4096"}
                    """)
                .exchangeSuccessfully()
                .expectBody()
                .jsonPath("$.name").isEqualTo("Bjorn")
                .jsonPath("$.phoneNumber").isEqualTo("1024-2048-4096")
                .returnResult()
                .getResponseHeaders().getLocation();

        assertThat(location).isNotNull();
        assertThat(location.toString()).matches(".*/buddyInfoes/\\d+");
    }

    @Test
    void testAddBuddyInfoToAddressBook() {
        URI addressBook = createAddressBook();
        URI buddy = createBuddyInfo("Bjorn", "1024-2048-4096");

        restClient.post().uri(addressBook + "/info")
                .contentType(MediaType.parseMediaType("text/uri-list"))
                .body(buddy.toString())
                .exchangeSuccessfully();

        restClient.get().uri(addressBook)
                .exchangeSuccessfully()
                .expectBody()
                .jsonPath("$.name").isEqualTo("TestBook");

        restClient.get().uri(addressBook + "/info")
                .exchangeSuccessfully()
                .expectBody()
                .jsonPath("$._embedded.buddyInfoes.length()").isEqualTo(1)
                .jsonPath("$._embedded.buddyInfoes[0].name").isEqualTo("Bjorn")
                .jsonPath("$._embedded.buddyInfoes[0]._links.self.href").isEqualTo(buddy.toString());
    }

    private URI createAddressBook() {
        return restClient.post().uri("/addressBooks")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaTypes.HAL_JSON)
                .body("""
                        {"name": "TestBook"}""")
                .exchangeSuccessfully()
                .expectBody()
                .jsonPath("$._links.info.href").exists()
                .returnResult()
                .getResponseHeaders().getLocation();
    }

    private URI createBuddyInfo(String name, String phoneNumber) {
        return restClient.post().uri("/buddyInfoes")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaTypes.HAL_JSON)
                .body("""
                    {"name": "%s", "phoneNumber": "%s"}
                    """.formatted(name, phoneNumber))
                .exchangeSuccessfully()
                .expectBody()
                .returnResult()
                .getResponseHeaders().getLocation();
    }
}
