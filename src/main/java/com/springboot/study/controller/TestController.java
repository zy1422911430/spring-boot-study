package com.springboot.study.controller;

import com.springboot.study.entity.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName: TestController
 * @Description TODO
 * @Author: zyd
 * @Date: 2018/9/28 10:31
 * @Version: 1.0
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping(value = "/test1")
    public String test1( String name, Integer age,Model model){
        model.addAttribute("name",name);
        model.addAttribute("age",age);
        return "test";
    }

    @RequestMapping(value = "/test2")
    public String test2(@RequestBody Test test, Model model){
        model.addAttribute("test",test);
        return "test2";
    }

    @RequestMapping(value = "/test3")
    @ResponseBody
    public ResponseEntity<Test> test3(@RequestBody Test test){
        return new ResponseEntity<Test>(test,HttpStatus.OK);
    }
}
