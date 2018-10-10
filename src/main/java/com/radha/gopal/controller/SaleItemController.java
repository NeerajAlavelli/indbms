package com.radha.gopal.controller;

import com.radha.gopal.model.Brand;
import com.radha.gopal.model.SaleItem;
import com.radha.gopal.repository.BrandRepository;
import com.radha.gopal.repository.SaleItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class SaleItemController{


    @Autowired
    private SaleItemRepository saleItemRepository;

    @ModelAttribute("saleitemform")
    private SaleItem formattribute(){
        return  new SaleItem();
    }

    @GetMapping("admin/saleitem")
    public String saleitemForm(Model model) {

        return "SaleItemform";
    }

    @PostMapping("admin/saleitem")
    public String checkReturnInfo(@Valid SaleItem saleItem, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.toString());
            return "SaleItemform";
        }

        saleItemRepository.save(saleItem);


        return "redirect:/admin/saleitem";
    }
}