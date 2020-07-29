package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

   @GetMapping("add")
   public String displayAtUserForm(){
       return "user/add";
   }

   @PostMapping()
    public String processAddUserForm(Model model, @ModelAttribute User user, String verifyPassword){
       if(user.getPassWord().equals(verifyPassword)) {
        model.addAttribute("name", user.getUserName());
       return "user/index";
       }
       model.addAttribute("error", "Passwprds do not match");
       model.addAttribute("username", user.getUserName());
       model.addAttribute("email", user.getEmail());
       return "user/add";
   }

}
