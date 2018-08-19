package org.topview.controller.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.topview.entity.organization.bo.SlideshowBo;
import org.topview.service.organization.SlideshowService;
import org.topview.util.Result;

import java.util.List;

@Controller
@CrossOrigin
public class SlideshowController {

    @Autowired
    private SlideshowService slideshowService;

    /**
     * 获取轮播图
     * @return Result中包含一个轮播图List，里面包含了图片的url和对应的社团id
     */
    @RequestMapping(value = "/selectSlideShow")
    @ResponseBody
    public Result selectSlideShow() {
        List<SlideshowBo> slideshowList = slideshowService.selectSlideShowService();
        return Result.success(slideshowList);
    }
}
