package com.github.konicai;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddressBookWebController {

    private final AddressBookRepository addressBookRepository;
    private final BuddyInfoRepository buddyInfoRepository;

    public AddressBookWebController(
            AddressBookRepository addressBookRepository,
            BuddyInfoRepository buddyInfoRepository
    ) {
        this.addressBookRepository = addressBookRepository;
        this.buddyInfoRepository = buddyInfoRepository;
    }

    @GetMapping("/")
    public String addressBooks(Model model) {
        final var books = addressBookRepository.findAll();
        model.addAttribute("books", books);

        // Provide all BuddyInfo entries separately in case none belong to an address book
        final var infoEntries = buddyInfoRepository.findAll();
        model.addAttribute("infoEntries", infoEntries);

        return "addressBooks"; // name of template
    }
}
