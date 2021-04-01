package cn.yq.demo.controller;

import cn.yq.demo.generator.TStudent;
import cn.yq.demo.service.ExceptionService;
import cn.yq.demo.service.TStudentService;
import cn.yq.demo.service.TStudentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/rest")
@CrossOrigin
public class TStudentController {
    @Resource
    private TStudentService tStudentService;
    @Resource
    private ExceptionService exceptionService;

    @GetMapping("/wherestudents")
    public List<TStudent> findStudentByNameAndPhoneUseWhere(@Valid @RequestBody TStudent stu){
        return tStudentService.findStudentByNameAndPhoneUseWhere(stu);
    }
    @GetMapping("/trimstudents")
    public List<TStudent> findStudentByNameAndPhoneUseTrim(@Valid @RequestBody TStudent stu){
        return tStudentService.findStudentByNameAndPhoneUseTrim(stu);
    }
    @GetMapping("/classesstudents")
    public List<TStudent> findStudentByManyClasses(@Valid @RequestBody int[] classes){
        return tStudentService.findStudentByManyClasses(classes);
    }
    @GetMapping("/Classstudents")
    public List<TStudent> findStudentByNameAndClass(@Valid @RequestBody TStudent stu){
        return tStudentService.findStudentByNameAndClass(stu);
    }

    @PutMapping("students")
    public void updateStudentByValue(@Valid @RequestBody TStudent stu){
        tStudentService.updateStudentByValue(stu);
    }
    @DeleteMapping("student")
    public void deleteStudentByName(@Valid @RequestBody TStudent stu){
        tStudentService.deleteStudentByName(stu);

    }
}
