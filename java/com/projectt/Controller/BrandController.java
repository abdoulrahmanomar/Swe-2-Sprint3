/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectt.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BrandController {

    @Autowired
    private brandRepository repositor;

    @GetMapping("/addbrand")
    public String addbrand(Model model) {
        model.addAttribute("brand", new Brand());
        return "addbrand";
    }

    @PostMapping("/addbrand")
    public String addbrand(Model model, @ModelAttribute Brand brand) {
        // System.out.println(product.getName());
        //System.out.println(product.getProductID());
        repositor.save(brand);
        model.addAttribute("brand", new Brand());

        return "addbrand";
    }

}
