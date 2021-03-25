package cn.yq.demo.service;

import cn.yq.demo.dao.CarJDBCDAO;
import cn.yq.demo.generator.CarMapper;
import cn.yq.demo.generator.Car;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CarServiceJDBCImpl implements CarService {

    @Resource
    private CarJDBCDAO carJDBCDAO;

    @Resource
    private CarMapper carMapper;

    @Override
    public void saveCar(Car car) {
//        carJDBCDAO.save(car);
        carMapper.insertSelective(car);
    }

    @Override
    public void deleteCar(Integer id) {
//        carJDBCDAO.deleteById(id);
        carMapper.deleteByPrimaryKey(id);
    }


    @Override
    @Transactional
    public void updateCar(Car car) {
        if (car.getId() == null) {
//            抛出异常
            new RuntimeException("汽车编号不存在");
        }else {
            carJDBCDAO.updateById(car);
        }
//        测试回滚事务
//        carJDBCDAO.deleteById(car.getId());
//        carJDBCDAO.save(car);
//                int a = 10/0;

//        carMapper.updateByPrimaryKeySelective(car);
    }

    @Override
    public Car getCar(Integer id) {
//        return carJDBCDAO.findById(id);
      return   carMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Car> getAll() {
//        return carJDBCDAO.findAll();
     return    carMapper.selectByExample(null);
    }
}
