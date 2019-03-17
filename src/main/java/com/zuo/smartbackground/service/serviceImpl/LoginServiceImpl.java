package com.zuo.smartbackground.service.serviceImpl;

import com.zuo.smartbackground.dao.UserMapper;
import com.zuo.smartbackground.model.User;
import com.zuo.smartbackground.model.UserExample;
import com.zuo.smartbackground.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {

        if(user==null||user.getAccount()==null
                ||user.getPassword()==null||user.getUserStatus()==null)
        {
            return null;
        }
        UserExample userExample = new UserExample();
        userExample.createCriteria().
                andAccountEqualTo(user.getAccount()).
                andPasswordEqualTo(user.getPassword()).
                andUserStatusEqualTo(user.getUserStatus());
        List<User> us  = userMapper.selectByExample(userExample);
        if(us!=null&&us.size()>0)
        {
            return us.get(0);
        }
        return null;
    }
}
