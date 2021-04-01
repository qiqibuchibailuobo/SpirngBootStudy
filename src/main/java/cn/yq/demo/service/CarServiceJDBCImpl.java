package cn.yq.demo.service;

import cn.yq.demo.dao.CarJDBCDAO;
import cn.yq.demo.generator.CarExample;
import cn.yq.demo.generator.CarMapper;
import cn.yq.demo.generator.Car;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
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


    public static final String CACHE_OBJECT = "car";
    public static final String CACHE_LIST_KEY  = "\"list\"";


    @Override
    @CacheEvict(value=CACHE_OBJECT,key=CACHE_LIST_KEY)
    public void saveCar(Car car) {
//        carJDBCDAO.save(car);
        carMapper.insertSelective(car);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = CACHE_OBJECT,key = CACHE_LIST_KEY),   //删除List集合缓存
            @CacheEvict(value = CACHE_OBJECT,key = "#id")  //删除单条记录缓存
    })//redis缓存方法实现删除
    public void deleteCar(Integer id) {
//        carJDBCDAO.deleteById(id);
        carMapper.deleteByPrimaryKey(id);
    }


    @Override
    @Transactional
    @Caching(evict = {
            @CacheEvict(value = CACHE_OBJECT,key = CACHE_LIST_KEY),   //删除List集合缓存
            @CacheEvict(value = CACHE_OBJECT,key = "#car.getId()")  //删除单条记录缓存
    })
    public void updateCar(Car car) {
//        if (car.getId() == null) {
////            抛出异常
//            new RuntimeException("汽车编号不存在");
//        }else {
//            carJDBCDAO.updateById(car);
//        }
//        测试回滚事务
//        carJDBCDAO.deleteById(car.getId());
//        carJDBCDAO.save(car);
//                int a = 10/0;

        carMapper.updateByPrimaryKeySelective(car);
    }

    @Override
    @Cacheable(value=CACHE_OBJECT,key="#id",sync = true)//redis缓存方法实现查询,sync解决缓存穿透
    public Car getCar(Integer id) {
//        return carJDBCDAO.findById(id);
//        CarExample carExample = new CarExample();
//       String value = "%" + id  + "%";
//        carExample.createCriteria().andColorLike(value);
//        List<Car> car = carMapper.selectByExample(carExample);
      return   carMapper.selectByPrimaryKey(id);
    }

    @Override
    @Cacheable(value=CACHE_OBJECT,key=CACHE_LIST_KEY)//redis缓存方法实现查询
    public List<Car> getAll() {
//        return carJDBCDAO.findAll();
     return    carMapper.selectByExample(null);
    }
}
