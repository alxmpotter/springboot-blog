package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class RollDice {

    @GetMapping("/roll-dice")
    public String guessANumber(Model modelView){

        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);

        modelView.addAttribute("numbers", numbers);


        return "roll-dice";


    }


    @GetMapping("/roll-dice/{n}")
    public String guessNumber(@PathVariable Integer n, Model modelView) {
        int dice = (int) (Math.random()*6 + 1);

        Boolean win = ("dice" == "guess") ? true : false;

        modelView.addAttribute("dice", dice);
        modelView.addAttribute("guess", n);
        return "roll-dice";

    }

}
