package com.example.hometask2.Controllers;

import com.example.hometask2.model.User;
import com.example.hometask2.service.UserDao;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class MyController {


    private final UserDao userDao;

    @GetMapping("/")
    public String userList(Model model){
        model.addAttribute("getUsers", userDao.getAll());
        return "index";
    }

    @PostMapping("/")
    public ModelAndView insertUsers(User user){
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("user",user);
        userDao.createUser(user);

        return mv;
    }


    @GetMapping("/")
    public String deleteUser(HttpServletRequest request){
        Long id = Long.parseLong(request.getParameter("id"));
        userDao.deleteById(id);
        return "index";
    }



//    @GetMapping("/")
//    public String getUserByName(String name, Model model,User user){
//        ModelAndView mv = new ModelAndView("index");
//        mv.addObject("dUser", user.getFirstName());
//        model.addAttribute("deleteUser", userDao.getByName(name));
//        return "index";
//    }



//    @RequestMapping("/")
//    @SneakyThrows
//    String main(ModelAndView model, User user){
//        model.addObject("user",user);
//        return "index";
//    }
}
