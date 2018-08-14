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

}
