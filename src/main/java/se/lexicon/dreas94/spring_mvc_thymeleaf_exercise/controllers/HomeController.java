package se.lexicon.dreas94.spring_mvc_thymeleaf_exercise.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController
{
    private List<String> contactViews = new ArrayList<>();

    public HomeController()
    {
        System.out.println("default data loaded");
        contactViews.add("Andreas Eriksson 070-xxxxxxx");
        contactViews.add("Tabea Teufel 070-xxxxxxx");
    }

    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public String defaultURL() {
        System.out.println("##### default method has been executed ####");
        return "index";
    }

    @GetMapping("/home")
    public String home(){
        System.out.println("##### home method has been executed ####");
        return "index";
    }

    @GetMapping("/index")
    public String index(){
        System.out.println("##### index method has been executed ####");
        return "index";
    }

    @GetMapping("/contact")
    public String displayContactForm(){
        System.out.println("##### contact method has been executed ####");
        return "contact";
    }

    @PostMapping("/contact")
    public String contact(@RequestParam("contactInfo")String contact)
    {
        System.out.println("Contact Info:" + contact);

        contactViews.add(contact);
        return "contact";
    }

    @GetMapping("/contacts")
    public String contactList(Model model)
    {
        System.out.println("Number of Contacts: " + contactViews.size());
        model.addAttribute("contactViews",contactViews);
        return "contacts";
    }
}
