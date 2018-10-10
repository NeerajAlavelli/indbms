package com.radha.gopal.controller;

import com.radha.gopal.model.Employee;
import com.radha.gopal.model.Supplier;
import com.radha.gopal.model.Wage;
import com.radha.gopal.repository.EmployeeRepository;
import com.radha.gopal.repository.WageRepository;
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
public class WageController{


    @Autowired
    private WageRepository wageRepository;



    @ModelAttribute("wageform")
    private Wage formattribute(){
        return new Wage();
    }

    @GetMapping("admin/wage")
    public String wageForm(Model model) {

        return "Wageform";
    }

    @PostMapping("admin/wage")
    public String checkReturnInfo(@Valid Wage wage, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.toString());
            return "Wageform";
        }

        wageRepository.save(wage);


        return "redirect:/admin/wage";
    }
    @GetMapping("admin/wagelist")
    public ModelAndView wageList(Model model) {


        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("Wagelist");

        List<Wage> wageList=wageRepository.findAll();

        modelAndView.addObject("list",wageList);

        return modelAndView ;
    }
}