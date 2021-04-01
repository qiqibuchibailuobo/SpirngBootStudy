package cn.yq.demo.service;

import cn.yq.demo.generator.TStudent;

import java.util.List;

public interface TStudentService {
    List<TStudent> findStudentByNameAndPhoneUseWhere(TStudent stu);
    List<TStudent> findStudentByNameAndPhoneUseTrim(TStudent stu);
    List<TStudent> findStudentByNameAndClass(TStudent stu);
    void updateStudentByValue(TStudent stu);
    List<TStudent> findStudentByManyClasses(int[] classes);
    void deleteStudentByName(TStudent stu);
}
