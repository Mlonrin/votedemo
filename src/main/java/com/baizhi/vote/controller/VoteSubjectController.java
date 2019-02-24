package com.baizhi.vote.controller;

import com.baizhi.vote.entity.VoteSubject;
import com.baizhi.vote.service.VoteSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/voteSubject")
public class VoteSubjectController {
    @Autowired
    private VoteSubjectService voteSubjectService;

    @RequestMapping("/addVoteSubject")
    public @ResponseBody
    boolean addVoteSubject(VoteSubject voteSubject){
        try {
            voteSubjectService.addVoteSubject(voteSubject);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @RequestMapping("/multiDelete")
    public @ResponseBody
    boolean multiDelete(int[] ids){
        try {
            voteSubjectService.multiDelete(ids);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @RequestMapping("/selectOne")
    public String selectOne(int vs_id, @ModelAttribute("user_number") int user_number, @ModelAttribute("option_number") int option_number, Model model){
        VoteSubject voteSubject = voteSubjectService.selectOne(vs_id);
        model.addAttribute("voteSubject",voteSubject);
        return "vote";
    }
}
