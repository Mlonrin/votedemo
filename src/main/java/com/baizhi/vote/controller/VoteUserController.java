package com.baizhi.vote.controller;

import com.baizhi.vote.entity.VoteUser;
import com.baizhi.vote.service.VoteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class VoteUserController {
    @Autowired
    private VoteUserService voteUserService;

    @RequestMapping("/register")
    public void register(VoteUser voteUser){
        voteUserService.register(voteUser);
    }

    @RequestMapping("/login")
    public @ResponseBody
    Map login(VoteUser voteUser, HttpSession session) {
        Map map = voteUserService.login(voteUser);
        if((boolean)map.get("isLogin")){
            session.setAttribute("user",map.get("user"));
        }
        return map;
    }
}
