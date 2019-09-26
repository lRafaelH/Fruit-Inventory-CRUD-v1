package com.example.OOPROGL.FINALS.controllers;

import com.example.OOPROGL.FINALS.model.Fruit;
import com.example.OOPROGL.FINALS.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class FruitController {
    @Autowired
    private FruitService service;

    @GetMapping("/")
    public String viewHomePage(Model model){
        List<Fruit> listFruits =service.listAll();
        model.addAttribute("listFruits", listFruits);
        return "index";
    }

    @RequestMapping("/new")
    public String showNewFruitForm(Model model){
        Fruit fruit = new Fruit();
        model.addAttribute("fruit",fruit);
        return "new_fruit";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Fruit fruit) {
        service.save(fruit);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductForm(@PathVariable(name = "id") long id) {
        ModelAndView mav = new ModelAndView("edit_fruit");
        Fruit fruit = service.get(id);
        mav.addObject("fruit", fruit);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") long id) {
        service.delete(id);
        return "redirect:/";
    }
}
