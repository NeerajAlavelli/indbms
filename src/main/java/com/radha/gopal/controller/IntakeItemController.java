package com.radha.gopal.controller;

import com.radha.gopal.model.Brand;
import com.radha.gopal.model.IntakeItem;
import com.radha.gopal.repository.BrandRepository;
import com.radha.gopal.repository.IntakeItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class IntakeItemController{


    @Autowired
    private IntakeItemRepository intakeItemRepository;

    @ModelAttribute("intakeitemform")
    private IntakeItem formattribute(){
        return  new IntakeItem();
    }

    @GetMapping("admin/intakeitem")
    public String intakeitemForm(Model model) {

        return "IntakeItemform";
    }

    @PostMapping("admin/intakeitem")
    public String checkReturnInfo(@Valid IntakeItem intakeItem, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.toString());
            return "IntakeItemform";
        }

        intakeItemRepository.save(intakeItem);


        return "redirect:/admin/intakeitem";
    }
}