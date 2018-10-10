package com.radha.gopal.controller;

import com.radha.gopal.model.Brand;
import com.radha.gopal.repository.BrandRepository;
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
public class BrandController{


    @Autowired
    private BrandRepository brandRepository;

    @ModelAttribute("brandform")
    private Brand formattribute(){
        return  new Brand();
    }

    @GetMapping("admin/brand")
    public String brandForm(Model model) {

        return "Brandform";
    }

    @PostMapping("admin/brand")
    public String checkReturnInfo(@Valid Brand brand, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.toString());
            return "Supplierform";
        }

        brandRepository.save(brand);


        return "redirect:/admin/brand";
    }
    @GetMapping("admin/brandlist")
    public ModelAndView brandList(Model model) {


        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("Brandlist");

        List<Brand> brandList=brandRepository.findAll();

        modelAndView.addObject("list",brandList);

        return modelAndView ;
    }
}