package org.topview.dao.application;

import org.topview.dao.BaseMapper;
import org.topview.entity.application.ApplicationResult;

import java.util.List;

public interface ApplicationResultMapper extends BaseMapper<ApplicationResult, Integer> {

    List<ApplicationResult> listAppResultByStage(int stageId);
}
