package org.topview.entity.application.po;

import java.util.Date;

/**
 * 报名结果实体类
 * @author Medwin。
 */
public class ApplicationResult {

    private int applicationId;

    private int stageId;

    private int status;

    private Date endTime;

    public ApplicationResult() {
    }

    public ApplicationResult(int applicationId, int stageId, int status, Date endTime) {
        this.applicationId = applicationId;
        this.stageId = stageId;
        this.status = status;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "ApplicationResult{" +
                "applicationId=" + applicationId +
                ", stageId=" + stageId +
                ", status=" + status +
                ", endTime=" + endTime +
                '}';
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public int getStageId() {
        return stageId;
    }

    public void setStageId(int stageId) {
        this.stageId = stageId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
