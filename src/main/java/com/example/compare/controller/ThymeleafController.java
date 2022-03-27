package com.example.compare.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Api(value = "ThymeleafController",tags = "thymeleaf")
public class ThymeleafController {
    /**
     * 跳转到收银台
     * @param total_amount  商品金额
     * @param out_trade_no  订单号
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String index(String total_amount,String out_trade_no,Model model){
        model.addAttribute("total_amount",total_amount);
        model.addAttribute("out_trade_no",out_trade_no);
        return "index";
    }

    /**
     *
     * @param total_amount  商品金额
     * @param out_trade_no  订单号
     * @param model
     * @return
     */
    @RequestMapping("/succeed")
    public String succeed(String total_amount,String out_trade_no,Model model){
        model.addAttribute("total_amount",total_amount);
        model.addAttribute("out_trade_no",out_trade_no);
        return "succeed";
    }
}
