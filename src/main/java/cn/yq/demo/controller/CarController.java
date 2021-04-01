package cn.yq.demo.controller;

import cn.yq.demo.exception.AjaxResponse;
import cn.yq.demo.generator.Car;
import cn.yq.demo.service.CarService;
import cn.yq.demo.service.ExceptionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/rest")
@CrossOrigin
public class CarController {
    @Resource
    CarService carService;
    @Resource
    private ExceptionService exceptionService;




    //@RequestMapping(value = "/cars/{id}",method = RequestMethod.GET)
    @GetMapping("/cars/{id}")
    public Car getCar(@PathVariable("id")Integer id){

//        List<Part> parts = new ArrayList<Part>(){{
//            add(new Part("steel","Glass"));
//            add(new Part("aluminium","Glass"));
//        }};
//
//        Car car = Car.builder()
//                .id(1)
//                .color("red")
//                .parts(parts)
//                .newDate(new Date()).build();
//
//        log.info("Car:"+car);

//        自定义异常测试
//        if(id == 1){
//            exceptionService.systemBizError();
//        }else {
//            exceptionService.userBizError(-1);
//        }
          Car car = carService.getCar(id);

        return car;
    }

    //@RequestMapping(value = "/cars",method = RequestMethod.POST)
    @PostMapping("/cars")
    public AjaxResponse addCar(@Valid @RequestBody Car car){

//        log.info("addCar:"+car);
        carService.saveCar(car);
        return AjaxResponse.success();
    }
//    @PostMapping("/cars")
//    public AjaxResponse addCar(@RequestParam String color,
//                               @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//                               @RequestParam Date newDate){
//
//        log.info("addCar:"+newDate);
//        return AjaxResponse.success();
//    }

    //@RequestMapping(value = "/cars",method = RequestMethod.PUT)
    @PutMapping("/cars")
    public void updateCar(@RequestBody Car car) {
        //        自定义异常测试
        if (carService.getCar(car.getId()) == null) {
             exceptionService.userBizError(-1);

        } else {
            carService.updateCar(car);

        }

//        log.info("updateCar:"+car);
//        carService.deleteCar(car.getId());
//        carService.saveCar(car);

        }

    //@RequestMapping(value = "/cars/{id}",method = RequestMethod.DELETE)
    @DeleteMapping("/cars/{id}")
    public AjaxResponse deleteCar(@PathVariable("id")Integer id){
//        log.info("deleteCar:"+id);
        carService.deleteCar(id);
        return AjaxResponse.success();
    }

    @GetMapping("/cars")
    public List<Car> getAllCar(){
        List<Car> cars = carService.getAll();

        return cars;
    }
}
