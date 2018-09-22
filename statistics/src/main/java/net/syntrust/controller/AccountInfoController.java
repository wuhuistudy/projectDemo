package net.syntrust.controller;

import net.syntrust.entity.Return;
import net.syntrust.service.AccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/accountInfo")
public class AccountInfoController {
    @Autowired
    public AccountInfoService accountInfoService;
    @RequestMapping
    public Return insertAccount(HttpServletRequest req, HttpServletResponse res){
        String account = req.getParameter("account");
        return new Return();
    }
}
