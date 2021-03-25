package cn.yq.demo.controller;

import cn.yq.demo.AjaxResponse;
import cn.yq.demo.generator.Car;
import cn.yq.demo.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/rest")
public class CarController {
    @Resource
    CarService carService;

    //@RequestMapping(value = "/cars/{id}",method = RequestMethod.GET)
    @GetMapping("/cars/{id}")
    public AjaxResponse getCar(@PathVariable("id")Integer id){

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
          Car car = carService.getCar(id);

        return AjaxResponse.success(car);
    }

    //@RequestMapping(value = "/cars",method = RequestMethod.POST)
    @PostMapping("/cars")
    public AjaxResponse addCar(@RequestBody Car car){

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
    public AjaxResponse updateCar(@RequestBody Car car){
        if(carService.getCar(car.getId())==null){
            return AjaxResponse.error();
        }else {
            carService.updateCar(car);
            return AjaxResponse.success();
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
    public AjaxResponse getAllCar(){
        List<Car> cars = carService.getAll();

        return AjaxResponse.success(cars);
    }
}
