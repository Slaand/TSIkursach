package com.tsi.student.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/")
public class LoginController {

    @RequestMapping(value={"", "/login"})
    public ModelAndView loginAuthorization() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            /* Если юзер залогинен и пытается пойти на основную страничку */
            return new ModelAndView("forward:/panel");
        } else {
            return new ModelAndView("login");
        }
    }
}