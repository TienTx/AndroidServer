/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author zOzDarKzOz
 */
@Controller
public class HomeCtr {

    @RequestMapping(value = {"", "/", "home.html"}, method = RequestMethod.GET)
    public ModelAndView home(ModelAndView model, HttpSession session,
            HttpServletRequest request, HttpServletResponse response) {
        model = new ModelAndView("/index");
        return model;
    }
}
