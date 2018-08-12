package org.topview.service.application;

import org.springframework.stereotype.Service;
import org.topview.entity.application.Application;

@Service
public interface ApplicationService {

    int addApplication(Application application);

    int deleteApplication(int id);



}
