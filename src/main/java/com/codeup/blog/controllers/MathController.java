package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @ResponseBody
    @GetMapping("/add/{numberOne}/and/{numberTwo}")
    public Long add(@PathVariable Long numberOne, @PathVariable Long numberTwo){
        return numberOne + numberTwo;
    }

    @ResponseBody
    @GetMapping("/subtract/{numOne}/from/{numTwo}")
    public Long subtract(@PathVariable Long numOne, @PathVariable Long numTwo){
        return numOne - numTwo;
    }

    @ResponseBody
    @GetMapping("/multiply/{numOne}/and/{numTwo}")
    public Long multiply(@PathVariable Long numOne, @PathVariable Long numTwo){
        return numOne *numTwo;
    }

    @ResponseBody
    @GetMapping("/divide/{numOne}/by/{numTwo}")
    public Long divide(@PathVariable Long numOne, @PathVariable Long numTwo){
        return numOne /numTwo;
    }


}
