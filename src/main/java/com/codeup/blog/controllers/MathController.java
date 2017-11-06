package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @ResponseBody
    @GetMapping("/add/{numberOne}/and/{numberTwo}")
    public Double add(@PathVariable Double numberOne, @PathVariable Double numberTwo){
        return numberOne + numberTwo;
    }

    @ResponseBody
    @GetMapping("/subtract/{numTwo}/from/{numOne}")
    public Double subtract(@PathVariable Double numOne, @PathVariable Double numTwo){
        return numOne - numTwo;
    }

    @ResponseBody
    @GetMapping("/multiply/{numOne}/and/{numTwo}")
    public Double multiply(@PathVariable Double numOne, @PathVariable Double numTwo){
        return numOne * numTwo;
    }

    @ResponseBody
    @GetMapping("/divide/{numOne}/by/{numTwo}")
    public Double divide(@PathVariable Long numOne, @PathVariable Double numTwo) {
        return numOne / numTwo;
    }

}
