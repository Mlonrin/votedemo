package com.baizhi.vote.controller;

import com.baizhi.vote.entity.VoteSubject;
import com.baizhi.vote.entity.VoteUser;
import com.baizhi.vote.service.VoteItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/voteItem")
public class VoteItemController {

    @Autowired
    private VoteItemService voteItemService;

    @RequestMapping("/addVoteItem")
    public @ResponseBody
    boolean addVoteItem(VoteSubject voteSubject, HttpSession session){

        try {
            VoteUser voteUser = (VoteUser) session.getAttribute("user");

            voteItemService.addVoteItem(voteSubject.getVoteItemList(),voteUser.getVu_user_id(),voteSubject.getVs_id());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
