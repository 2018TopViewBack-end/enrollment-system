package org.topview.controller.administrator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.topview.entity.organization.bo.OrganizationBo;
import org.topview.entity.organization.vo.OrganizationStatus;
import org.topview.util.Result;

import java.util.ArrayList;
import java.util.List;

public class OrganizationTest {

    @Test
    public void updateUserStatusTest() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<OrganizationBo> list = new ArrayList<>();
        OrganizationBo organizationBo = new OrganizationBo();
        list.add(organizationBo);
        System.out.println(objectMapper.writeValueAsString(Result.success(list)));
    }

    public void test() {

    }
}
