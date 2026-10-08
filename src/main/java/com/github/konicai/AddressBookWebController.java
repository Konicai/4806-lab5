package com.github.konicai;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddressBookWebController {

    private final AddressBookRepository addressBookRepository;

    public AddressBookWebController(AddressBookRepository addressBookRepository) {
        this.addressBookRepository = addressBookRepository;
    }

    @GetMapping("/")
    public String addressBooks(Model model) {
        final var books = addressBookRepository.findAll();
        model.addAttribute("books", books);
        return "addressBooks"; // name of template
    }
}
