package cn.yq.demo.service;


import cn.yq.demo.generator.Car;

import java.util.List;

public interface CarService {
    void saveCar(Car car);

    void deleteCar(Integer id);

    void updateCar(Car car);

    Car getCar(Integer id);

    List<Car> getAll();
}
