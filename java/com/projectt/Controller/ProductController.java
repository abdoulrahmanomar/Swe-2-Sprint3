/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectt.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;


@Controller
public class ProductController {
    @Autowired
    private ProductRepository repository;
    @GetMapping("/addproduct")
    public String addproduct(Model model){
        model.addAttribute("product",new Product());
        return "addproduct";
    }
    @PostMapping("/addproduct")
    public String addproduct(Model model ,@ModelAttribute Product product){
   
       repository.save(product);
        model.addAttribute("product",new Product());

        return "addproduct";
    }
    
      
       @GetMapping("/add_p_storeowner")
    public String add(Model model){
        model.addAttribute("product",new Product());
        Iterable <Product  > productit =repository.findAll();
        ArrayList <Product> product2=new ArrayList<Product>();
    
        for(Product product1:productit){
            product2.add(product1);
          }
        model.addAttribute("products",product2);
        return"add_p_storeowner";
    }
        
    @PostMapping("/add_p_storeowner")
    public String add(Model model ,@ModelAttribute Product product){
        Iterable <Product  > productit =repository.findAll();
        ArrayList <Product> product2=new ArrayList<Product>();
    
        for(Product product1:productit){
            product2.add(product1);
          }
            model.addAttribute("products",product2);
        for(int i=0;i<product2.size();i++){
            if((product2.get(i).getProductID()==product.getProductID())){
                 product2.get(i).setAdd_by_owner(true);
                  repository.save(product2.get(i));
                return "add_p_storeowner";
                
            }
        }
        
        return "add_p_storeowner";
              
        
    }  
    
    
       @GetMapping("/productinfo")
    public String productinfo(Model model){
        //model.addAttribute("product",new Product());
        Iterable <Product  > productit =repository.findAll();
        ArrayList <Product> product2=new ArrayList<Product>();
    
        for(Product product1:productit){
            product2.add(product1);
          }
        model.addAttribute("productinfo",product2);
        return"productinfo";
    }
        
    @PostMapping("/productinfo")
    public String productinfo(Model model ,@ModelAttribute Product product){
        Iterable <Product  > productit =repository.findAll();
        ArrayList <Product> product2=new ArrayList<Product>();
    
        for(Product product1:productit){
            product2.add(product1);
          }
            model.addAttribute("productinfo",product2);
       
            
        
        return "productinfo";
              
        
    }  
}
    
        
    
    

