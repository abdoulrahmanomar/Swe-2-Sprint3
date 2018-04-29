package com.projectt.Controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;


@Controller
public class UserController {
    
     @Autowired
    private userRepository repository;
    
    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user",new User());
        return "register";
    }
    @PostMapping("/register")
    public String registerr(Model model ,@ModelAttribute User user){
       repository.save(user);
       model.addAttribute("user",new User());

        return "register";
    }
    @GetMapping("/login")
    public String loginn(Model model){
        model.addAttribute("user",new User());
    return"login";
    }
    
    
    
    @PostMapping("/login")
    public String loginn(Model model ,@ModelAttribute User user){
        Iterable <User> userit =repository.findAll();
        ArrayList <User> user2=new ArrayList<User>();
    
        for(User user1:userit){
            user2.add(user1);
          }
   
        for(int i=0;i<user2.size();i++){
            if((user2.get(i).getUsername().equals(user.getUsername()))
                    &&(user2.get(i).getPassword().equals(user.getPassword()))
                    &&(user2.get(i).getType().equals(user.getType()))
                    &&(user.getType().equals("admin"))){
                
                return "success";
                
            }else if((user2.get(i).getUsername().equals(user.getUsername()))
                    &&(user2.get(i).getPassword().equals(user.getPassword()))
                    &&(user2.get(i).getType().equals(user.getType()))
                    &&(user.getType().equals("user"))){
                    
                    return "successu";
        
            }else if((user2.get(i).getUsername().equals(user.getUsername()))
                    &&(user2.get(i).getPassword().equals(user.getPassword()))
                    &&(user2.get(i).getType().equals(user.getType()))
                    &&(user.getType().equals("storeowner"))){
                
                return "successowner";
            
            }
        }
        return "failed";
              
        
    }  
}
