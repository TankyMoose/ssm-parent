package com.jaxon.test.controller;

import com.jaxon.test.po.User;
import com.jaxon.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("doRegister")
    public String register(User user,String repassword){

        User dbUser = userService.findUserByNameAndPassword(user);
        if(dbUser != null){
            return "redirect:/pages/register.jsp";
        }

        if(repassword.equals(user.getPassword())){
            userService.addUser(user);
        }else{
            return "redirect:/pages/register.jsp";
        }



        return "success";
    }

    @RequestMapping("doLogin")
    public String login(Model model, User user, HttpSession session){

        User dbUser = userService.findUserByNameAndPassword(user);

        session.setAttribute("user",dbUser);

        model.addAttribute("user",dbUser);

        return "success";
    }

   /* @RequestMapping("doLogin")
    public ModelAndView login(User user, HttpSession session){

        User dbUser = userService.findUserByNameAndPassword(user);

        session.setAttribute("user",dbUser);

        ModelAndView mav = new ModelAndView();

        mav.addObject("user",dbUser);
        mav.setViewName("redirect:/pages/success.jsp");

        return mav;
    }*/
}
