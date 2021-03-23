package cn.yq.demo.dao;

import cn.yq.demo.model.Car;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class CarJDBCDAO {

    @Resource
    private JdbcTemplate jdbcTemplate;

//    添加
    public void save(Car car){
        //jdbcTemplate.update适合于insert 、update和delete操作；
        jdbcTemplate.update("INSERT INTO car(color,newDate) values(?, ?)",
                car.getColor(),
                car.getNewDate());
    }

    //删除
    public void deleteById(Integer id) {
        //jdbcTemplate.update适合于insert 、update和delete操作；
        jdbcTemplate.update("DELETE FROM car WHERE id = ?",id);

    }

    //更新
    public void updateById(Car car) {
        //jdbcTemplate.update适合于insert 、update和delete操作；
        jdbcTemplate.update("UPDATE car SET color = ?, newDate = ?  WHERE id = ?",
                car.getColor(),
                car.getNewDate(),
                car.getId());

    }

    //根据id查找
    public Car findById(Integer id) {
        //queryForObject用于查询单条记录返回结果
        return (Car) jdbcTemplate.queryForObject("SELECT * FROM car WHERE id=?",
                new Object[]{id},new BeanPropertyRowMapper<>(Car.class));
    }
    //查询所有
    public List<Car> findAll(){
        //query用于查询结果列表
        return (List<Car>) jdbcTemplate.query("SELECT * FROM car ",  new BeanPropertyRowMapper<>(Car.class));
    }
}
