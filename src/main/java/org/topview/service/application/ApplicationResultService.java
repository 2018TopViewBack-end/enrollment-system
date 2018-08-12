package org.topview.service.application;

import org.springframework.stereotype.Service;
import org.topview.entity.application.ApplicationResult;

@Service
public interface ApplicationResultService {

    ApplicationResult checkResult(String tel, String appId); //查看报名状态
}
