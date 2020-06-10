package com.yhr.literature.controller;

import com.yhr.literature.pojo.Paper;
import com.yhr.literature.pojo.PaperDetails;
import com.yhr.literature.pojo.Result;
import com.yhr.literature.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Paper")
public class PaperController {

    @Autowired
    private PaperService paperService;

    @PostMapping("/findList")
    @ResponseBody
    public List<Paper> findList(@RequestBody Map<String,Object> searchMap){
        return paperService.findList(searchMap);
    }

    @PostMapping("/add")
    @ResponseBody
    public Result add(@RequestBody Paper paper){
        paperService.add(paper);
        return new Result();
    }

    @PostMapping("/update")
    @ResponseBody
    public Result update(@RequestBody Paper paper){
        paperService.update(paper);
        return new Result();
    }

    @GetMapping("/delete")
    @ResponseBody
    public Result delete(String id) {
        paperService.delete(id);
        return new Result();
    }

    @GetMapping("/findById")
    @ResponseBody
    public Paper findById(String id){
        return paperService.findById(id);
    }


}
