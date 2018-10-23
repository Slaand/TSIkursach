package com.tsi.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.tsi.student.entity.*;
import com.tsi.student.repository.StudentRepository;

import java.util.List;

@Controller
@RequestMapping(path="/panel")
public class MainController {
    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(value = "/student_info", method = RequestMethod.GET)
    public String student_info(Model model)
    {
        List<Student> studentList = studentRepository.findAll();
        model.addAttribute("studList",studentList);
        return "student/search";
    }
}

