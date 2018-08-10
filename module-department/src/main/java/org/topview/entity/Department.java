package org.topview.entity;

import java.util.List;
import java.util.Map;

public class Department {
    private int id;

    private String name;

    private String logoUrl;

    private Map<Integer,String> pics; //key为标识，value为url

    private String introduction;

    private Integer messageNum;//发送短信数量，便于统计

    private List<String> stages;//用于保存部门所有阶段名称，需排序
}
