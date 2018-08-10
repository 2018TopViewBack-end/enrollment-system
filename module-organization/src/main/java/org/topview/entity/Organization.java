package org.topview.entity;

import java.util.List;
import java.util.Map;

public class Organization {
    int id;

    String name;

    String logoUrl;

    String tel;

    String category;

    String introduction;

    String linkman;

    List<Department> departments; //社团名下部门

    Map<Integer,String> pics; //key为标识，value为url

    Integer status;           // 0 待审核,1 已通过，2 被封禁

    String apikey;            //短信平台apikey

    List<CustomField> customFields; //自定义报名表字段列表
}
