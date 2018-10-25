package com.tsi.student.controller;

import com.tsi.student.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.tsi.student.repository.StudentRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(value = "/panel", method = RequestMethod.GET)
    public String panel(Model model)
    {
        List<Student> studentList = studentRepository.findAll();
        model.addAttribute("studList", studentList);
        return "panel";
    }

    @RequestMapping(value={"/add"})
    public ModelAndView addAccount() {
        return new ModelAndView("add");
    }

    @RequestMapping(value={"/edit"}, method = RequestMethod.GET)
    public ModelAndView editAccount(@RequestParam("id") int id) {
//        System.out.println("Your result:" +id);
        return new ModelAndView("edit");
    }

    @RequestMapping(value={"/remove"}, method = RequestMethod.GET)
    public ModelAndView removeAccount(@RequestParam("id") int id) {
//        System.out.println("Your result #2:" +id);
        return new ModelAndView("remove");
    }
}

