package com.radha.gopal.controller;

import com.radha.gopal.model.Brand;
import com.radha.gopal.model.Customer;
import com.radha.gopal.repository.BrandRepository;
import com.radha.gopal.repository.CustomerRepository;
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
public class CustomerController{


    @Autowired
    private CustomerRepository customerRepository;

    @ModelAttribute("customerform")
    private Customer formattribute(){
        return  new Customer();
    }

    @GetMapping("admin/customer")
    public String customerForm(Model model) {

        return "Customerform";
    }

    @PostMapping("admin/customer")
    public String checkReturnInfo(@Valid Customer customer, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.toString());
            return "Customerform";
        }

        customerRepository.save(customer);


        return "redirect:/admin/customer";
    }
    @GetMapping("admin/customerlist")
    public ModelAndView customerList(Model model) {


        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("Customerlist");

        List<Customer> customerList=customerRepository.findAll();

        modelAndView.addObject("list",customerList);

        return modelAndView ;
    }
}