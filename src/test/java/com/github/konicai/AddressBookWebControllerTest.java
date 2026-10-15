package com.github.konicai;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.client.RestTestClient;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;



@SpringBootTest
@AutoConfigureRestTestClient
public class AddressBookWebControllerTest {

    @Autowired
    RestTestClient restClient;

    @Test
    void test() {
        // Very basic test to make sure that the page loads and one of the preloaded entries is provided
        restClient.get().uri("/")
                .exchangeSuccessfully()
                .expectHeader().contentTypeCompatibleWith(MediaType.TEXT_HTML)
                .expectBody(String.class)
                .consumeWith(r -> {
                    var page = r.getResponseBody();
                    assertThat(page).contains("<td>555-555-5555</td>");
                });
    }
}
