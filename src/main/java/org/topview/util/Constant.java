package org.topview.util;

/**
 * 常量类
 */
public class Constant {
    public static final String OK = "OK";

    public static final String NOT_FOUND = "没有找到请求资源";

    public static final String PASSED = "已通过";

    public static final String DID_NOT_PASS = "未通过";

    public static final String TO_BE_DECIDED = "待审核";

    public static final String INFO_NOT_FOUND = "没有找到您的信息";

    public static final String NO_INFO = "暂无";

    public static final String LOGIN_SUCCESS = "登陆成功";

    public static final String LOGIN_FAIL = "帐号或密码错误";

    public static final String ORGANIZATION = "organization";

    public static final String DEPARTMENT = "department";

    public static final String ADMIN = "admin";

    public static final String SUBMIT_FAILED = "您已报名，请勿重复报名！";

    public static final String SUBMIT_SUCCEED = "报名成功！";

    public static final String CAN_NOT_ADD_STAGE = "还有上一轮未审核的报名，无法开启下一轮";

    public static final String ADD_FAIL = "新增阶段失败";

    public static final String FAIL_TO_DELETE = "删除失败";

    public static final String MODIFY_STAGE_FAIL = "修改招新阶段失败";

    public static final String PREFIX_OF_STUDENT_ID = "311";

    public static class OrganizationCategory {
        public static final String COLLEGE = "校级";
        public static final String ACADEMY = "院级";
        public static final String INTERESTS = "兴趣类";
    }

    public static class OrganizationStatus {
        public static final int DOWNLINE = 0;
        public static final int ONLINE = 1;
        public static final int FORBIDDEN = 2;
    }

    public static class Page {
        public static final int DEFAULT_PAGE_NUM = 0;
        public static final int PAGE_SIZE = 8;
    }

    public static final String MODIFY_DEPARTMENT_FAIL= "修改部门失败";

    public static final String ADD_DEPARTMENT_FAIL = "新增部门失败";

    public static final String EMPTY_DEPARTMENT = "没有部门";
}
