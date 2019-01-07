package com.tsi.student.controller;

import com.tsi.student.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.tsi.student.repository.StudentRepository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
        model.addAttribute("student",studentList.get(id));
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
    public String searchBy(Model model,@RequestParam(value = "criteria") String criteria) {
        List<Student> studentList = studentRepository.findAll();
        for(Student stud : studentList)
        {
            if (stud.getGroup().equals(criteria)) {
                List<Student> studentListGr = studentRepository.findStudentByGroup(criteria);
                model.addAttribute("studList", studentListGr);
            }
            else if(stud.getSurname().equals(criteria))
                {
                List<Student> studentListSur = studentRepository.findStudentBySurname(criteria);
                model.addAttribute("studList", studentListSur);
            }
            else if(stud.getCity().equals(criteria))
            {
                List<Student> studentListCity = studentRepository.findStudentByCity(criteria);
                model.addAttribute("studList", studentListCity);
            }
            else if(stud.getFaculty().equals(criteria))
            {
                List<Student> studentListFac = studentRepository.findStudentByFac(criteria);
                model.addAttribute("studList", studentListFac);
            }
            else if(stud.getName().equals(criteria))
            {
                List<Student> studentListName = studentRepository.findStudentByName(criteria);
                model.addAttribute("studList", studentListName);
            }
            else if(stud.getCountry().equals(criteria))
            {
                List<Student> studentListCountry = studentRepository.findStudentByCountry(criteria);
                model.addAttribute("studList", studentListCountry);
            }
            else if(stud.getPersonalCode().equals(criteria))
            {
                List<Student> studentListCode = studentRepository.findStudentByPersonalCode(criteria);
                model.addAttribute("studList", studentListCode);
            }
        }
        return "search";
    }
}

