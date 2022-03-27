package com.example.compare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeleafController {
    @RequestMapping("/index")
    public String index(String total_amount,String out_trade_no,Model model){
        model.addAttribute("total_amount",total_amount);
        model.addAttribute("out_trade_no",out_trade_no);
        return "index";
    }

    @RequestMapping("/succeed")
    public String succeed(String total_amount,String out_trade_no,Model model){
        model.addAttribute("total_amount",total_amount);
        model.addAttribute("out_trade_no",out_trade_no);
        return "succeed";
    }
}
