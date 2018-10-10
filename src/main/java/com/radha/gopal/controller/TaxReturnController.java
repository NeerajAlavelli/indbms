package com.radha.gopal.controller;

import com.radha.gopal.model.Supplier;
import com.radha.gopal.model.TaxReturn;
import com.radha.gopal.repository.ReturnRepository;
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
public class TaxReturnController{


    @Autowired
    private ReturnRepository returnRepository;



    @ModelAttribute("returnform")
    private TaxReturn formattribute(){
        return  new TaxReturn();
    }

    @GetMapping("admin/returns")
    public String taxreturnForm(Model model) {

        return "Returnform";
    }

    @PostMapping("admin/returns")
    public String checkReturnInfo(@Valid TaxReturn taxReturn, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.toString());
            return "Returnform";
        }

        returnRepository.save(taxReturn);


        return "redirect:/admin/returns";
    }
    @GetMapping("admin/returnslist")
    public ModelAndView returnsList(Model model) {


        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("Returnslist");

        List<TaxReturn> returnsList=returnRepository.findAll();

        modelAndView.addObject("list",returnsList);

        return modelAndView ;
    }
}