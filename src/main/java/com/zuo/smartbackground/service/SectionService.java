package com.zuo.smartbackground.service;

import com.zuo.smartbackground.model.Section;

import java.util.List;

public interface SectionService {
    List<Section> getAllSection();
    int addSection(Section section);
    int updateSection(Section section);
    int deleteSection(int sectionId);
}
