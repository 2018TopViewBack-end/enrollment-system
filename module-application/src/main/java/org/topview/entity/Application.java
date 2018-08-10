package org.topview.entity;

import java.util.List;
import java.util.Map;

public class Application {
    private int id;

    private String stuName;

    private String gender;

    private String academy;

    private String majorAndClass;

    private String wechat;

    private String tel;

    private String stuId;

    private String intentionDepartment;

    private String dormitory;

    private boolean adjustable; //是否允许调剂

    private String introduction;

    private List<ApplicationResult> results;//用于保存每个阶段结果

    private Map<Integer,String> customValues;//key为自定义字段customField的id，value为字段值
}
