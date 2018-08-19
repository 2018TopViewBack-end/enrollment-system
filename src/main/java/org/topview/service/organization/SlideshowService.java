package org.topview.service.organization;

import org.springframework.stereotype.Service;
import org.topview.entity.organization.bo.SlideshowBo;

import java.util.List;

@Service
public interface SlideshowService {

    /**
     * 获取轮播图图片
     * @return 一个轮播图List，里面包含了图片的url和对应的社团id
     */
    List<SlideshowBo> selectSlideShowService();
}
