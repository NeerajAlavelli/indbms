package com.radha.gopal.controller;

import com.radha.gopal.model.Invoice;
import com.radha.gopal.model.Item;
import com.radha.gopal.repository.ItemRepository;
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
public class ItemController{


    @Autowired
    private ItemRepository itemRepository;

    @ModelAttribute("itemform")
    private Item formattribute(){
        return  new Item();
    }

    @GetMapping("admin/item")
    public String itemForm(Model model) {

        return "Itemform";
    }

    @PostMapping("admin/item")
    public String checkReturnInfo(@Valid Item item, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.toString());
            return "Itemform";
        }

        itemRepository.save(item);


        return "redirect:/admin/item";
    }
    @GetMapping("admin/itemlist")
    public ModelAndView itemList(Model model) {


        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("Itemlist");

        List<Item> itemList=itemRepository.findAll();

        modelAndView.addObject("list",itemList);

        return modelAndView ;
    }
}