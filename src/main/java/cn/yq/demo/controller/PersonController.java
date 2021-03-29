package cn.yq.demo.controller;

import cn.yq.demo.dao.PersonRepository;
import cn.yq.demo.exception.AjaxResponse;
import cn.yq.demo.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/person")
@CrossOrigin
public class PersonController {
    @Resource
    PersonRepository personRepository;
    @PostMapping("/persons")
    public AjaxResponse addCar(@Valid @RequestBody Person person){

//        log.info("addCar:"+car);
        personRepository.save(person);
        return AjaxResponse.success();
    }
}
