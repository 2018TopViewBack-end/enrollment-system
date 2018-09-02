package org.topview.entity.application.bo;

import java.util.List;

public class ApplicationBo {
    private List<Integer> applicationIds;

    private Integer status;

    private Integer stageId;

    public ApplicationBo() {
    }

    public List<Integer> getApplicationIds() {
        return applicationIds;
    }

    public void setApplicationIds(List<Integer> applicationIds) {
        this.applicationIds = applicationIds;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStageId() {
        return stageId;
    }

    public void setStageId(Integer stageId) {
        this.stageId = stageId;
    }
}
