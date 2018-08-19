package org.topview.dao.organization;

import org.topview.dao.BaseMapper;
import org.topview.entity.organization.bo.SlideshowBo;
import org.topview.entity.organization.po.Slideshow;

import java.util.List;

public interface SlideshowMapper extends BaseMapper<Slideshow, Integer> {

    /**
     * 查询5张轮播图
     * @return 轮播图List
     */
    List<SlideshowBo> selectSlideShow();
}
