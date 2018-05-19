package com.kg.ssm.service.impl;

import com.kg.ssm.dao.ITUserDao;
import com.kg.ssm.pojo.TUser;
import com.kg.ssm.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

/**
 * Created with IDEA
 * Created by ${jie.chen} on 2016/7/14.
 */
@Service("t_userService")
public class UserServiceImpl implements UserService {

    @Resource
    private ITUserDao itUserDao ;

    @Override
    public TUser findUserByUsername(String username) {
        TUser t_user = itUserDao.findUserByUsername(username);
        return t_user;
    }

    @Override
    public Set<String> findRoles(String username) {
        return itUserDao.findRoles(username);
    }

    @Override
    public Set<String> findPermissions(String username) {
        return itUserDao.findPermissions(username);
    }
}
