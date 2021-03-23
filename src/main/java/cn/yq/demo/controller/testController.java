package cn.yq.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class testController {

    @RequestMapping("/test1")
    public String test(){
        return "111111";
    }

}
