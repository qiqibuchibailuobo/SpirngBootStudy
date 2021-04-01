package cn.yq.demo.service;

import cn.yq.demo.generator.TStudent;
import cn.yq.demo.generator.TStudentDao;
import cn.yq.demo.generator.TStudentExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class TStudentServiceImpl implements TStudentService {
    @Resource
    private TStudentDao tstudentDao;




    @Override
    public List<TStudent> findStudentByNameAndPhoneUseWhere(TStudent stu) {
//        String value = "%" + stu.getStuName()  + "%";
//        TStudentExample tstudentExample = new TStudentExample();
//
//        if (stu.getStuName().length() != 0 && stu.getStuTelphone().length() != 0){
//            tstudentExample.or()
//                    .andStuNameLike(value).andStuNameIsNotNull()
//                    .andStuTelphoneEqualTo(stu.getStuTelphone()).andStuTelphoneIsNotNull();
//        }
//        if(stu.getStuName().length()==0){
//            tstudentExample.or().andStuTelphoneEqualTo(stu.getStuTelphone());
//        }
//        if(stu.getStuTelphone().length()==0){
//            tstudentExample.or().andStuNameLike(value);
//        }
//        List<TStudent> tstudentList = tstudentDao.selectByExample(tstudentExample);
//        if(tstudentList.size()!=0){
//            return tstudentList;
//        }else {
//            return tstudentDao.selectByExample(null);
//        }
        return tstudentDao.findStudentByNameAndPhoneUseWhere(stu);
    }

    @Override
    public List<TStudent> findStudentByNameAndPhoneUseTrim(TStudent stu) {
        return tstudentDao.findStudentByNameAndPhoneUseTrim(stu);
    }

    @Override
    public List<TStudent> findStudentByNameAndClass(TStudent stu) {
        return tstudentDao.findStudentByNameAndClass(stu);
    }

    @Override
    public void updateStudentByValue(TStudent stu) {
        tstudentDao.updateStudentByValue(stu);
    }

    @Override
    public List<TStudent> findStudentByManyClasses(int[] classes) {
        return tstudentDao.findStudentByManyClasses(classes);
    }

    @Override
    public void deleteStudentByName(TStudent stu) {
        tstudentDao.deleteStudentByName(stu);
    }
}
