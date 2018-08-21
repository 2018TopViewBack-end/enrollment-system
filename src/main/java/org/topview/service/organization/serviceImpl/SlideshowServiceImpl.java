package org.topview.service.organization.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.topview.dao.organization.SlideshowMapper;
import org.topview.entity.organization.bo.SlideshowBo;
import org.topview.service.organization.SlideshowService;

import java.util.List;

@Service
public class SlideshowServiceImpl implements SlideshowService {

    @Autowired
    private SlideshowMapper slideshowMapper;

    /**
     * 获取轮播图图片
     * @return 一个轮播图List，里面包含了图片的url和对应的社团id
     */
    @Override
    public List<SlideshowBo> selectSlideShowService() {
        return slideshowMapper.selectSlideShow();
    }
}
