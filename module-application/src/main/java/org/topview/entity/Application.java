package org.topview.entity;

import java.util.List;
import java.util.Map;

public class Application {
    int id;

    String stuName;

    String gender;

    String academy;

    String majorAndClass;

    String wechat;

    String tel;

    String stuId;

    String intentionDepartment;

    String dormitory;

    boolean adjustable; //是否允许调剂

    String introduction;

    List<ApplicationResult> results;//用于保存每个阶段结果

    Map<Integer,String> customValues;//key为自定义字段customField的id，value为字段值
}
