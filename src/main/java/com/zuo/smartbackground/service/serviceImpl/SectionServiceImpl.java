package com.zuo.smartbackground.service.serviceImpl;

import com.zuo.smartbackground.dao.SectionMapper;
import com.zuo.smartbackground.model.Section;
import com.zuo.smartbackground.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SectionServiceImpl implements SectionService{

    @Autowired
    private SectionMapper sectionMapper;
    @Override
    public List<Section> getAllSection() {
        return sectionMapper.selectByExample(null);
    }

    @Override
    public int addSection(Section section) {
        return sectionMapper.insertSelective(section);
    }

    @Override
    public int updateSection(Section section) {
        return sectionMapper.updateByPrimaryKeySelective(section);
    }

    @Override
    public int deleteSection(int sectionId) {
        return sectionMapper.deleteByPrimaryKey(sectionId);
    }
}
