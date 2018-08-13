package org.topview.service.application.serviceImpl;

<<<<<<< HEAD
import org.springframework.stereotype.Service;
import org.topview.service.application.ApplicationResultService;

@Service
public class ApplicationResultServiceImpl implements ApplicationResultService {
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.topview.dao.application.ApplicationMapper;
import org.topview.dao.application.ApplicationResultMapper;
import org.topview.entity.application.po.ApplicationResult;
import org.topview.service.application.ApplicationResultService;

/**
 *
 */
@Service
public class ApplicationResultServiceImpl implements ApplicationResultService {

    @Autowired
    ApplicationMapper applicationMapper;

    @Autowired
    ApplicationResultMapper applicationResultMapper;

//    @Override
    public ApplicationResult checkResult(String tel, String studentId) {
        //getAppId
//        int applicationId = applicationMapper.getId(tel, studentId);

        //getResult
//        applicationResultMapper.selectByPrimaryKey(applicationId);
        return null;
    }
>>>>>>> a0b860245429652611597a456504229a419a9062
}
