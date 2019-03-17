package com.zuo.smartbackground.controller;

import com.zuo.smartbackground.model.Section;
import com.zuo.smartbackground.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/section")
public class SectionController {
    @Autowired
    private SectionService sectionService;

    @ResponseBody
    @RequestMapping(value = "getAllSection",method = RequestMethod.GET)
    public List<Section> getAllSection()
    {
        return sectionService.getAllSection();
    }

    @ResponseBody
    @RequestMapping(value = "addSection",method = RequestMethod.POST)
    public int addSection(Section section){
        return sectionService.addSection(section);
    }
    @ResponseBody
    @RequestMapping(value = "updateSection",method = RequestMethod.POST)
    public int updateSection(Section section){
        return sectionService.updateSection(section);
    }
    @ResponseBody
    @RequestMapping(value = "addSection",method = RequestMethod.GET)
    public int deleteSection(int sectionId){
        return sectionService.deleteSection(sectionId);
    }

}
