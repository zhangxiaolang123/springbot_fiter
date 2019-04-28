package com.zxl.filter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Describe
 * @Author zxl
 * @Date 2019-04-28 10:59
 */
// http://127.0.0.1/filter/test?pageSize=100&name=zxl访问
@RestController
@RequestMapping("/filter")
public class FilterController {
    @GetMapping("/test")
    public String test(@RequestParam("name")String userName,@RequestParam("pageSize")String pageSize){
        System.out.println(pageSize);
        System.out.println(userName);
        return "success";
    }

}
