package com.yhr.literature.controller;

import com.yhr.literature.dao.ThemeMapper;
import com.yhr.literature.pojo.Paper;
import com.yhr.literature.pojo.Result;
import com.yhr.literature.pojo.Theme;
import com.yhr.literature.service.PaperService;
import com.yhr.literature.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/theme")
public class ThemeController {
    @Autowired
    private ThemeService themeService;

    @PostMapping("/findList")
    @ResponseBody
    public List<Theme> findList(@RequestBody Map<String,Object> searchMap){
        return themeService.findList(searchMap);
    }

    @PostMapping("/add")
    @ResponseBody
    public Result add(@RequestBody Theme paper){
        themeService.add(paper);
        return new Result();
    }

    @PostMapping("/update")
    @ResponseBody
    public Result update(@RequestBody Theme paper){
        themeService.update(paper);
        return new Result();
    }

    @GetMapping("/delete")
    @ResponseBody
    public Result delete(String id) {
        themeService.delete(id);
        return new Result();
    }

    @GetMapping("/findById")
    @ResponseBody
    public Theme findById(String id){
        return themeService.findById(id);
    }
}
