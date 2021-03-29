package cn.yq.demo.dao;

import org.springframework.data.repository.CrudRepository;
import cn.yq.demo.model.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//泛型第二个参数是id的数据类型

@Transactional
@Repository
public interface PersonRepository extends CrudRepository<Person, String> {
 // 继承CrudRepository，获取基本的CRUD操作
}