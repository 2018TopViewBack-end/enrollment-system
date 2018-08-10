package org.topview.entity;

import java.util.List;
import java.util.Map;

public class Department {
    int id;

    String name;

    String logoUrl;

    Map<Integer,String> pics; //key为标识，value为url

    String introduction;

    Integer messageNum;//发送短信数量，便于统计

    List<String> stages;//用于保存部门所有阶段名称，需排序
}
