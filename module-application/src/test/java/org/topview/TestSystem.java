package org.topview;

import org.junit.Test;
import org.topview.util.CodeUtil;

public class TestSystem {

    @Test
    public void test1(){
        String code = CodeUtil.generateUniqueCode();
        System.out.println(code);
    }
}
