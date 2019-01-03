package com.tsi.student.controller;

import com.tsi.student.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.tsi.student.repository.StudentRepository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class MainController {

    private Student student;

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(value = "/panel", method = RequestMethod.GET)
    public String panel(Model model)
    {
        List<Student> studentList = studentRepository.findAll();
        model.addAttribute("studList", studentList);
        return "panel";
    }

    @RequestMapping(value={"/add"}, method = RequestMethod.GET)
    public String addAccount(Model model) {
        model.addAttribute("student",new Student());
        return "add";
    }

    @RequestMapping(value={"/new_student"}, method = RequestMethod.POST)
    public String create(Model model, @ModelAttribute(value = "student") Student student) {
        studentRepository.save(student);
        return "add_success";
    }

    @RequestMapping(value={"/edit_student"}, method = RequestMethod.POST)
    public String edit(Model model, @ModelAttribute(value = "student") Student student) {
        studentRepository.save(student);
        return "edit";
    }

    @RequestMapping(value={"/edit"}, method = RequestMethod.GET)
    public String editAccount(@RequestParam("id") int id, Model model) {
        List<Student> studentList = studentRepository.findAll();
        model.addAttribute("student",studentList.get(id - 1)); // Найс костыль, не? :D
        return "edit_client";
    }

    @RequestMapping(value={"/remove"}, method = RequestMethod.GET)
    public String removeAccount(@RequestParam("id") int id) {
        List<Student> studentList = studentRepository.findAll();
        for(Student stud : studentList)
        {
            if(stud.getId() == id)
            {
                studentRepository.deleteById(id);
            }
        }
        return "remove";
    }
    @RequestMapping(value={"/search"}, method = RequestMethod.POST)
    public String searchBy(Model model, @RequestParam("id") int id , @RequestParam("surname") String surname, @RequestParam("group") String group, HttpSession session, HttpServletRequest request) {
       String type = request.getParameter("type");
        switch (type) {
            case "id_s":
                List<Student> studentListId = studentRepository.findStudentByID(id);
                model.addAttribute("studList", studentListId);
                break;
            case "surname_s":
                List<Student> studentListSur = studentRepository.findStudentBySurname(surname);
                model.addAttribute("studList", studentListSur);
                break;
            case "group_s":
                List<Student> studentListGr = studentRepository.findStudentByGroup(group);
                model.addAttribute("studList", studentListGr);
                break;
        }
        return "search";
    }
}

