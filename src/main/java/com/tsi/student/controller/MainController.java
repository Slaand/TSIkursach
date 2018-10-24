package com.tsi.student.controller;

import com.tsi.student.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.tsi.student.repository.StudentRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}

