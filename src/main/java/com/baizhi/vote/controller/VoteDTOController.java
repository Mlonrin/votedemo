package com.baizhi.vote.controller;

import com.baizhi.vote.dao.VoteDTODao;
import com.baizhi.vote.service.VoteDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/voteDTO")
public class VoteDTOController {

    @Autowired
    public VoteDTOService voteDTOService;

    @RequestMapping("/selectByTitle")
    public @ResponseBody
    Map selectByTitle(int page, int rows, String title){

        if(title!=null&&title!=""){
            title = "%"+title+"%";
        }else {
            title = null;
        }

        Map map = new HashMap();
        List<VoteDTODao> voteDTODaoList = voteDTOService.selectByTitle(title, page, rows);

        int count = voteDTOService.getCount(title);

        map.put("rows",voteDTODaoList);
        map.put("total",count);

        return map;
    }
}
