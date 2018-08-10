package org.topview.entity;

import java.util.List;
import java.util.Map;

public class Organization {
    private int id;

    private String name;

    private String logoUrl;

    private String tel;

    private String category;

    private String introduction;

    private String linkman;

    private List<Department> departments; //社团名下部门

    private Map<Integer,String> pics; //key为标识，value为url

    private Integer status;           // 0 待审核,1 已通过，2 被封禁

    private String apikey;            //短信平台apikey

    private List<CustomField> customFields; //自定义报名表字段列表
}
