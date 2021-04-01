package cn.yq.demo.generator;

import cn.yq.demo.generator.TStudent;
import cn.yq.demo.generator.TStudentExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TStudentDao {
    long countByExample(TStudentExample example);

    int deleteByExample(TStudentExample example);

    int deleteByPrimaryKey(String stuId);

    int insert(TStudent record);

    int insertSelective(TStudent record);

    List<TStudent> selectByExample(TStudentExample example);

    TStudent selectByPrimaryKey(String stuId);

    int updateByExampleSelective(@Param("record") TStudent record, @Param("example") TStudentExample example);

    int updateByExample(@Param("record") TStudent record, @Param("example") TStudentExample example);

    int updateByPrimaryKeySelective(TStudent record);

    int updateByPrimaryKey(TStudent record);

    List<TStudent> findStudentByNameAndPhoneUseWhere(TStudent stu);
    List<TStudent> findStudentByNameAndPhoneUseTrim(TStudent stu);
    List<TStudent> findStudentByNameAndClass(TStudent stu);
    void updateStudentByValue(TStudent stu);
    List<TStudent> findStudentByManyClasses(int[] classes);
    void deleteStudentByName(TStudent stu);
}