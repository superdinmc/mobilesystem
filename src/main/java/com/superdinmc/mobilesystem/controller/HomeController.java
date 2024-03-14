package com.superdinmc.mobilesystem.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/AllProducts")
    public String AllProduct() {
        return "all-products";
    }

    @GetMapping("/bestseller")
    public String BestSeller() {
        return "bestseller";
    }

    @GetMapping("/newproduct")
    public String NewProduct() {
        return "newproduct";
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest req, Exception ex) {
        //logger.error("Request: " + req.getRequestURL() + " raised " + ex);

        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", ex);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error");
        return mav;
    }
//    @GetMapping("/404")
//    public String notFound() {
//        return "forward:/error";
//    }
}
