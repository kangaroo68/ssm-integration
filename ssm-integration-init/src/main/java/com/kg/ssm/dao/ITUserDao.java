package com.kg.ssm.dao;

import com.kg.ssm.pojo.TUser;

import java.util.Set;

/**
 * Created with IDEA
 * Created by ${jie.chen} on 2016/7/14.
 */
public interface ITUserDao {
    TUser findUserByUsername(String username);

    Set<String> findRoles(String username);

    Set<String> findPermissions(String username);
}
