package com.yhr.literature.controller;

import com.yhr.literature.pojo.Paper;
import com.yhr.literature.pojo.PaperDetails;
import com.yhr.literature.pojo.Result;
import com.yhr.literature.service.PaperDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/paperDetails")
public class paperDetialsController {
    @Autowired
    private PaperDetailsService paperDetailsService;

    @PostMapping("/add")
    @ResponseBody
    public Result add(@RequestBody PaperDetails paper){
        paperDetailsService.add(paper);
        return new Result();
    }

    @PostMapping("/update")
    @ResponseBody
    public Result update(@RequestBody PaperDetails paper){
        paperDetailsService.update(paper);
        return new Result();
    }

    @GetMapping("/findByWid")
    @ResponseBody
    public PaperDetails findByWid(String id){
        return paperDetailsService.findByWid(id) ;
    }
}
