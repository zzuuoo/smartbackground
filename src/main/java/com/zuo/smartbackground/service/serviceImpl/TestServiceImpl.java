package com.zuo.smartbackground.service.serviceImpl;

import com.zuo.smartbackground.dao.AdminMapper;
import com.zuo.smartbackground.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService{

    @Autowired
    private AdminMapper adminMapper;

    private void inti()
    {
    }
}
