package com.radha.gopal.controller;

import com.radha.gopal.model.Brand;
import com.radha.gopal.model.Expense;
import com.radha.gopal.model.Invoice;
import com.radha.gopal.repository.InvoiceRepository;
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
public class InvoiceController{


    @Autowired
    private InvoiceRepository invoiceRepository;

    @ModelAttribute("invoiceform")
    private Invoice formattribute(){
        return  new Invoice();
    }

    @GetMapping("admin/invoice")
    public String invoiceForm(Model model) {

        return "Invoiceform";
    }

    @PostMapping("admin/invoice")
    public String checkReturnInfo(@Valid Invoice invoice, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.toString());
            return "Invoiceform";
        }

        invoiceRepository.save(invoice);


        return "redirect:/admin/invoice";
    }
    @GetMapping("admin/invoicelist")
    public ModelAndView invoiceList(Model model) {


        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("Invoicelist");

        List<Invoice> invoiceList=invoiceRepository.findAll();

        modelAndView.addObject("list",invoiceList);

        return modelAndView ;
    }
}