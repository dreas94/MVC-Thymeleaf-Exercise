package se.lexicon.dreas94.spring_mvc_thymeleaf_exercise.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FeverController
{
    private float temperature = Integer.MAX_VALUE;

    @GetMapping("fever")
    public String fever(Model model)
    {
        System.out.println("##### fever method has been executed ####");
        if(temperature != Integer.MAX_VALUE)
        {
            String message = "Your internal temperature is " + temperature + " C. ";
            if(temperature <= 35)
            {
                message += "You have Hypothermia, seek healthcare immediately.";
            }
            else if(temperature < 36)
            {
                message += "You are a bit cold, might be Hypothermia";
            }
            else if(temperature < 37.6)
            {
                message += "You have a normal body temp.";
            }
            else if(temperature < 38)
            {
                message += "You have a heightened body temp might be fever.";
            }
            else if(temperature < 39)
            {
                message += "You have a fever, take it easy.";
            }
            else if(temperature < 40)
            {
                message += "You have a high fever, seek healthcare.";
            }
            else
            {
                message += "You have a extreme fever, seek healthcare now or risk permanent damage.";
            }
            model.addAttribute("message", message);
            temperature = Integer.MAX_VALUE;
        }
        return "fever";
    }

    @PostMapping("/fever")
    public String contact(@RequestParam("temperatureCelsius")float temperature)
    {
        System.out.println("Temperature: " + temperature);

        this.temperature = temperature;

        return "redirect:/fever";
    }
}
