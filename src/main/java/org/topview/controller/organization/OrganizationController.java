package org.topview.controller.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.topview.util.Result;

@Controller
@RequestMapping(value = "/organization")
public class OrganizationController {



    @ResponseBody
    public Result updateOrganization() {
        return null;
    }


}
