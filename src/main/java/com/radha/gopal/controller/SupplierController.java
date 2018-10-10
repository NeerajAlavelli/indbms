package com.radha.gopal.controller;

import com.radha.gopal.model.Item;
import com.radha.gopal.model.Supplier;
import com.radha.gopal.model.TaxReturn;
import com.radha.gopal.repository.ReturnRepository;
import com.radha.gopal.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class SupplierController{


    @Autowired
    private SupplierRepository supplierRepository;

    @ModelAttribute("supplierform")
    private Supplier formattribute(){
        return new Supplier();
    }

    @GetMapping("admin/supplier")
    public String supplierForm(Model model) {

        return "Supplierform";
    }

    @PostMapping("admin/supplier")
    public String checkReturnInfo(@Valid Supplier supplier, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.toString());
            return "Supplierform";
        }

        supplierRepository.save(supplier);


        return "redirect:/admin/supplier";
    }
    @GetMapping("admin/supplierlist")
    public ModelAndView supplierList(Model model) {


        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("Supplierlist");

        List<Supplier> supplierList=supplierRepository.findAll();

        modelAndView.addObject("list",supplierList);

        return modelAndView ;
    }
}