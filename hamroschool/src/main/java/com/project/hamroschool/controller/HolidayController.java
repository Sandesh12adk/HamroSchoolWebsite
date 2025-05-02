package com.project.hamroschool.controller;

import com.project.hamroschool.model.Holiday;
import com.project.hamroschool.service.HolidayService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HolidayController {

    private final HolidayService holidayService;

    public HolidayController(HolidayService holidayService) {
        this.holidayService = holidayService;
    }

    @GetMapping("/holidays")
    public String holidays(@RequestParam(required = false) boolean FESTIVAL,
                           @RequestParam(required = false) boolean FEDERAL, Model model) {
        model.addAttribute("FESTIVAL", FESTIVAL);
        model.addAttribute("FEDERAL", FEDERAL);
        List<Holiday> holidays = holidayService.getHolidays();
        Holiday.Type[] types = Holiday.Type.values();
        for (Holiday.Type type : types) {
            model.addAttribute(type.toString(), holidays.stream().filter(x -> x.getType().equals(type))
                    .collect(Collectors.toList()));
        }
        return "holiday";
    }

    @GetMapping("/holidays/{kun}")
    public String holiday(@PathVariable(required = false) String kun, Model model) {
        if (kun != null) {
            if (kun.equalsIgnoreCase("all")) {
                model.addAttribute("FESTIVAL", true);
                model.addAttribute("FEDERAL", true);
            } else if (kun.equalsIgnoreCase("festival")) {
                model.addAttribute("FESTIVAL", true);
                model.addAttribute("FEDERAL", false);
            } else if (kun.equalsIgnoreCase("federal")) {
                model.addAttribute("FESTIVAL", false);
                model.addAttribute("FEDERAL", true);
            }
        }
        List<Holiday> holidays = holidayService.getHolidays();
        Holiday.Type[] types = Holiday.Type.values();
        for (Holiday.Type type : types) {
            model.addAttribute(type.toString(), holidays.stream().filter(x -> x.getType().equals(type))
                    .collect(Collectors.toList()));
        }
        return "holiday";
    }

    @GetMapping("/addholidays")
    public String addHolidays(Model model) {
        model.addAttribute("holidayobj", new Holiday());
        model.addAttribute("success", false);  // Initialize success flag
        return "addholidays";
    }

    @PostMapping("/saveholiday")
    public String saveHoliday(@Valid @ModelAttribute(name = "holidayobj") Holiday holiday,
                              Errors errors, Model model, RedirectAttributes redirectAttributes) {
        if (errors.hasErrors()) {
            model.addAttribute("success", false);  // Add success flag false in case of errors
            return "addholidays";
        } else {
            holidayService.addHoliday(holiday);
            redirectAttributes.addFlashAttribute("success", true);  // Add success flag in flash
        }
        return "redirect:/addholidays";
    }
    @GetMapping("/removeholiday")
    public String removeHoliday(@RequestParam(required = false) String reason){
        holidayService.removeHoliday(reason);
        return "holiday";
    }
}
